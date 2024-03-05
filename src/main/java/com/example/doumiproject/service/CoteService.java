package com.example.doumiproject.service;

import com.example.doumiproject.responsedto.CommentDto;
import com.example.doumiproject.responsedto.CoteDto;
import com.example.doumiproject.responsedto.PostDto;
import com.example.doumiproject.responsedto.TagDto;
import com.example.doumiproject.entity.Cote;

import java.util.List;

public interface CoteService {
    public List<PostDto> getAllCote(int page, int pageSize);
    public List<PostDto> getAllCote();
    public int getTotalPages(int pageSize);
    public CoteDto getCote(long postId);
    public List<CommentDto> getComments(long postId);
    public List<TagDto> getAllTags();
    public Long saveCote(Cote cote, Long userId);
    public int getTotalPages(int pageSize, String keyword);
    public List<PostDto> getSearchCote(String keyword, int page, int pageSize);
    public void updateCote(Cote cote, Long postId, Long userId);
    public void deleteCote(long postId);
}

