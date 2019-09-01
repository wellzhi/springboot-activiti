package com.dapeng.flow.controller;


import com.dapeng.flow.repository.service.ImageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.*;


/**
 * @author liuxz
 * @since 2019-03-22
 */
@RestController
@RequestMapping("api/flow/img")
@Api(value = "Test", tags = {"跟踪高亮"})
public class ImageController {
    protected static Logger logger = LoggerFactory.getLogger(ImageController.class);
    @Autowired
    private ImageService imageService;

    @RequestMapping(value = "/viewProcessImg", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "流程图跟踪及高亮显示", produces = "application/json")
    public void viewProcessImg(String instanceId, HttpServletResponse response) throws IOException {
        OutputStream os = null;
        try {
            String directory = "F:" + File.separator + "temp" + File.separator;
            final String suffix = ".png";
            File folder = new File(directory);
            File[] files = folder.listFiles();
            for (File file : files) {
                if (file.getName().equals(instanceId + suffix)) {
                    file.delete();
                }
            }

            byte[] processImage = imageService.getFlowImgByProcInstId(instanceId);
            File dest = new File(directory + instanceId + suffix);
            os = new FileOutputStream(dest, true);
            os.write(processImage, 0, processImage.length);
            os.flush();


        } catch (Exception e) {
            logger.error("viewProcessImg---- {}", ExceptionUtils.getStackTrace(e));
        } finally {
            if (os != null) {
                os.close();
            }
        }

    }

}

