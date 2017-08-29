package com.lq.plat.link.service.impl;

import com.lq.plat.link.file.InfoFile;
import com.lq.plat.link.file.InfoFileDto;
import com.lq.plat.link.repository.InfoFileRepository;
import com.lq.plat.link.service.InfoFileService;
import com.lq.plat.link.utils.DTOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 李强
 * @version 1.0.0
 * @date 2017/7/22
 */
@Service
public class InfoFileServiceImpl implements InfoFileService {

    @Autowired
    private InfoFileRepository infoFileRepository;

    @Override
    public InfoFileDto save(InfoFile infoFile) {
        InfoFile nInfoFile = infoFileRepository.save(infoFile);
        return DTOUtils.map(nInfoFile, InfoFileDto.class);
    }

    @Override
    public InfoFile findOne(Long id) {
        InfoFile infoFile = infoFileRepository.findOne(id);
        return infoFile;
    }


}
