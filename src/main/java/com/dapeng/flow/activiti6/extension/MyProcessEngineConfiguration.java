package com.dapeng.flow.activiti6.extension;

import org.activiti.engine.impl.cfg.StandaloneProcessEngineConfiguration;

import java.io.InputStream;
/**
 * 接管activiti封装的mybatis映射文件
 *
 * @author Administrator*/
public class MyProcessEngineConfiguration extends StandaloneProcessEngineConfiguration {
    @Override
    public InputStream getMyBatisXmlConfigurationStream() {
        return getResourceAsStream("com/dapeng/flow/activiti6/extension/mapping/mappings.xml");
    }
}
