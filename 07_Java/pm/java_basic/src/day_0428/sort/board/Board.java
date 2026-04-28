package day_0428.sort.board;

import java.time.LocalDateTime;

public class Board {
    private String title;
    private int viewCount;
    private LocalDateTime createdAt;

    public Board(String title, int viewCount, LocalDateTime createdAt) {
        this.title = title;
        this.viewCount = viewCount;
        this.createdAt = createdAt;
    }

    public String getTitle() {
        return title;
    }

    public int getViewCount() {
        return viewCount;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    @Override
    public String toString() {
        return "Board{" +
                "title='" + title + '\'' +
                ", viewCount=" + viewCount +
                ", createdAt=" + createdAt +
                '}';
    }
}
