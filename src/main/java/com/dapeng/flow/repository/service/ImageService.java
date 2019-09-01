package com.dapeng.flow.repository.service;


import org.springframework.stereotype.Service;

/**
 * @author Administrator
 */
public interface ImageService {
    byte[] getFlowImgByProcInstId(String procInstId) throws Exception;

}
