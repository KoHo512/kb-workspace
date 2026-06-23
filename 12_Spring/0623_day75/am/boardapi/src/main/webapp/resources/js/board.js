// 삭제 버튼 click 이벤트 핸들러
document.querySelector('.delete').onclick = function () {
    if(!confirm("정말 삭제하시겠습니다?")) return;

    document.getElementById('deleteForm').submit();
}