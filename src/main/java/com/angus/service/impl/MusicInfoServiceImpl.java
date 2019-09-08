package com.angus.service.impl;

import com.angus.dao.mapper.MusicInfoMapper;
import com.angus.dao.pojo.MusicInfo;
import com.angus.service.MusicInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicInfoServiceImpl implements MusicInfoService {
    @Autowired
    private MusicInfoMapper musicInfoMapper;

    @Override
    public List<MusicInfo> getMusicInfo(MusicInfo musicInfo) {
        List<MusicInfo> musicInfos = musicInfoMapper.selectAll(null);
        return musicInfos;
    }
}
