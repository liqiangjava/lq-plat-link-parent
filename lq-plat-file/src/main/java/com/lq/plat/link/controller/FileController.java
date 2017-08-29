package com.lq.plat.link.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lq.plat.link.Controller.PlatformController;
import com.lq.plat.link.PlatformResult;
import com.lq.plat.link.constant.PlatformConstants;
import com.lq.plat.link.file.InfoFile;
import com.lq.plat.link.file.InfoFileDto;
import com.lq.plat.link.file.InfoFilePara;
import com.lq.plat.link.service.InfoFileService;
import com.lq.plat.link.util.fastdfs.FastDFSClient;
import com.lq.plat.link.utils.ApiUtils;
import com.lq.plat.link.utils.DTOUtils;
import io.swagger.annotations.*;
import org.apache.commons.lang.StringUtils;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.WebAsyncTask;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.Callable;

/**
 * @author 李强
 * @version 1.0.0
 * @date 2017/7/20
 */
@RestController
@Api(value = "文件服务", description = "文件服务接口")
public class FileController extends PlatformController {

    @Autowired
    private InfoFileService infoFileService;

    @ApiOperation(value = "文件上传服务", notes = "文件上传接口")
    @PostMapping("admin/file/upload")
    @ApiResponses({
            @ApiResponse(code = PlatformConstants.API_RESPONSE_SUCCESS_CODE, message = PlatformConstants.API_RESPONSE_SUCCESS_MESSAGE, response = InfoFileDto.class),
            @ApiResponse(code = PlatformConstants.API_RESPONSE_FALSE_CODE, message = PlatformConstants.API_RESPONSE_FALSE_MESSAGE, response = PlatformResult.class)
    })
    public WebAsyncTask<ResponseEntity<PlatformResult>> upload(
            @ApiParam("上传文件") @RequestParam  final MultipartFile file) {

        Callable<ResponseEntity<PlatformResult>> callable =
                new Callable<ResponseEntity<PlatformResult>>() {

                    @Override
                    public ResponseEntity<PlatformResult> call() throws Exception {
                        try {
                            File fastFile = new File(System.getProperty("java.io.tmpdir") + System.getProperty("file.separator") +
                                    file.getName());
                            file.transferTo(fastFile);
                            String filePath = file.getOriginalFilename();
                            String fileType = StringUtils.substringAfterLast(file.getOriginalFilename(), ".");
                            String fileId = null;
                            String fileName = file.getName();
                            Long fileSize = file.getSize();
                            fileId = FastDFSClient.uploadFile(fastFile, filePath);
                            InfoFilePara infoFilePara = new InfoFilePara(fileName, fileType, fileSize, fileId);
                            return ApiUtils.ok(infoFileService.save(DTOUtils.map(infoFilePara, InfoFile.class)));

                        } catch (Exception e) {
                            return ApiUtils.error("文件上传失败");
                        }

                    }
                };

        return getWebAsyncTask(callable);
    }


    @ApiOperation(value = "文件下载服务", notes = "文件下载接口")
    @GetMapping("admin/file/download")
    public void download(@ApiParam("上传文件ID,如:1") @RequestParam(value = "id",
            required = true)   final Long id, HttpServletRequest request, HttpServletResponse response) throws Exception {

        InfoFile infoFile = infoFileService.findOne(id);
        if (infoFile == null) {
            writeJsonString(response, (JSONObject) JSON.toJSON(ApiUtils.error("文件不存在")));
        }
        String fileId = infoFile.getOriginalPath();
        try (InputStream inputStream = FastDFSClient.downloadFile(fileId);
             OutputStream outputStream = response.getOutputStream();) {
            response.setContentType("application/x-download");
            response.addHeader("Content-Disposition", "attachment;filename=" + infoFile.getName() + "." + infoFile.getType());

            IOUtils.copy(inputStream, outputStream);
            outputStream.flush();
        }

    }


}
