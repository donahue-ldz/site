package com.yidumen.cms.service.impl;

import com.yidumen.cms.service.VideoService;
import com.yidumen.dao.VideoDAO;
import com.yidumen.dao.entity.Video;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author 蔡迪旻 <yidumen.com>
 */
public class VideoServiceImpl implements VideoService, Serializable {

    private final Logger log = LoggerFactory.getLogger(VideoServiceImpl.class);
    @Inject
    private VideoDAO videoDAO;

    @Override
    public List<Video> getVideos() {
        log.debug("获取全部视频");
        return videoDAO.findAll();
    }

    @Override
    public void updateVideo(Video video) {
        log.debug("更新Video {}", video.getTitle());
        videoDAO.edit(video);
    }

    @Override
    public Video find(Long id) {
        return videoDAO.find(id);
    }

    @Override
    public Video find(String file) {
        return videoDAO.find(file);
    }

    @Override
    public void removeVideo(Video video) {
        videoDAO.remove(video);
        log.debug("视频 {} 已删除", video.getTitle());
    }

}
