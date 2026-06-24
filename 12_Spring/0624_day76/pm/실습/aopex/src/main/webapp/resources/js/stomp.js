let stompClient = null;
let currentRoomId = null;
let currentSender = null;
let messageSubscription = null;
let userSubscription = null;

function setConnected(connected) {
    document.querySelector('#connect').disabled = connected;
    document.querySelector('#disconnect').disabled = !connected;
    document.querySelector('#roomId').disabled = connected;
    document.querySelector('#sender').disabled = connected;
    document.querySelector('#send').disabled = !connected;
}

function connect(event) {
    event.preventDefault();

    currentRoomId = document.querySelector('#roomId').value.trim() || 'lobby';
    currentSender = document.querySelector('#sender').value.trim();

    if (!currentSender) {
        alert('이름을 입력하세요.');
        return;
    }

    stompClient = new StompJs.Client({
        brokerURL: `ws://${location.host}/chat-app`,
        reconnectDelay: 5000,
        debug: function (str) {
            console.log(str);
        }
    });

    stompClient.onConnect = function () {
        setConnected(true);
        clearMessages();

        messageSubscription = stompClient.subscribe(`/topic/rooms/${currentRoomId}/messages`, function (message) {
            const body = JSON.parse(message.body);
            showChatMessage(body);
        });

        userSubscription = stompClient.subscribe(`/topic/rooms/${currentRoomId}/users`, function (message) {
            const body = JSON.parse(message.body);
            renderUserList(body);
        });

        stompClient.publish({
            destination: '/app/chat.join',
            body: JSON.stringify({
                roomId: currentRoomId,
                sender: currentSender
            })
        });
    };

    stompClient.onWebSocketError = function (error) {
        console.error('WebSocket 오류:', error);
    };

    stompClient.onStompError = function (frame) {
        console.error('Broker 오류:', frame.headers['message']);
        console.error('상세:', frame.body);
    };

    stompClient.activate();
}

function disconnect(event) {
    event.preventDefault();

    if (stompClient && stompClient.connected) {
        stompClient.publish({
            destination: '/app/chat.leave',
            body: JSON.stringify({})
        });
    }

    if (messageSubscription) messageSubscription.unsubscribe();
    if (userSubscription) userSubscription.unsubscribe();

    if (stompClient) {
        stompClient.deactivate();
    }

    setConnected(false);
}

function sendMessage(event) {
    event.preventDefault();

    if (!stompClient || !stompClient.connected) {
        alert('먼저 연결하세요.');
        return;
    }

    const content = document.querySelector('#content').value.trim();
    if (!content) {
        alert('메시지를 입력하세요.');
        return;
    }

    stompClient.publish({
        destination: '/app/chat.send',
        body: JSON.stringify({
            roomId: currentRoomId,
            sender: currentSender,
            content: content
        })
    });

    document.querySelector('#content').value = '';
}

function showChatMessage(message) {
    const tbody = document.querySelector('#chat-messages');
    const tr = document.createElement('tr');
    const td = document.createElement('td');

    if (message.type === 'ENTER' || message.type === 'LEAVE' || message.type === 'SYSTEM') {
        td.className = 'system';
        td.textContent = `[${message.roomId}] ${message.content} (현재 ${message.participantCount}명)`;
    } else {
        if (message.sender === currentSender) {
            td.className = 'me';
        }
        td.textContent = `${message.sender}: ${message.content}`;
    }

    tr.appendChild(td);
    tbody.appendChild(tr);
}

function renderUserList(userListMessage) {
    document.querySelector('#user-count').textContent = userListMessage.count;

    const userListDiv = document.querySelector('#user-list');
    userListDiv.innerHTML = '';

    userListMessage.users.forEach(function (user) {
        const div = document.createElement('div');
        div.textContent = user;
        userListDiv.appendChild(div);
    });
}

function clearMessages() {
    document.querySelector('#chat-messages').innerHTML = '';
    document.querySelector('#user-list').innerHTML = '';
    document.querySelector('#user-count').textContent = '0';
}

document.querySelector('#connect').addEventListener('click', connect);
document.querySelector('#disconnect').addEventListener('click', disconnect);
document.querySelector('#message-form').addEventListener('submit', sendMessage);
setConnected(false);
