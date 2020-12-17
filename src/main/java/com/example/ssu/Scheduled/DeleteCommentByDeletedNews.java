package com.example.ssu.Scheduled;

import com.example.ssu.Entity.Comment;
import com.example.ssu.Entity.News;
import com.example.ssu.Helper.AbstractStatus;
import com.example.ssu.Repository.CommentRepository;
import com.example.ssu.Repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@EnableScheduling
@Component
@Transactional
public class DeleteCommentByDeletedNews {
    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private NewsRepository newsRepository;

    @Scheduled(cron = "*/15 * * * * *", zone = "Asia/Dubai")
    public void reportCurrentTime() {
        for (News item : newsRepository.findByStatus(AbstractStatus.ARCHIVE)) {
            for (Comment com : item.getComments()) {
                com.setStatus(AbstractStatus.ARCHIVE);
                commentRepository.save(com);
            }
        }
    }
}
