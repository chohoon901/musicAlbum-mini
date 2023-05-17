package com.spring.boot.musicAlbum.board.model;

import com.spring.boot.musicAlbum.comment.model.Comment;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name="board")
public class BoardDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String bTitle;
    private String bContent;
    private String bUserID;
    private String bPassword;
    private String bImage;
    private String bSound;

    @Column(nullable = false, updatable = false, name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    @OneToMany(mappedBy = "board", cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Comment> comments = new ArrayList<>();
}
