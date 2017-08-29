package com.lq.plat.link.service;

import com.lq.plat.link.file.InfoFile;
import com.lq.plat.link.file.InfoFileDto;

/**
 * @author 李强
 * @version 1.0.0
 * @date 2017/7/22
 */
public interface InfoFileService {

    public InfoFileDto save(InfoFile infoFile);


    public InfoFile findOne(Long id);
}
