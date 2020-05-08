package com.destiny.lodbase.common.config;

import com.destiny.lodbase.common.service.UidServiceImpl;
import com.destiny.lodbase.common.service.UidService;
import com.github.wujun234.uid.utils.DockerUtils;
import com.github.wujun234.uid.utils.NetUtils;
import com.github.wujun234.uid.worker.WorkerIdAssigner;
import com.github.wujun234.uid.worker.WorkerNodeType;
import com.github.wujun234.uid.worker.entity.WorkerNodeEntity;
import org.apache.commons.lang.math.RandomUtils;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 唯一id生成配置类
 *
 * @author leeboyka
 */
@Configuration
@ConditionalOnClass({UidServiceImpl.class})
public class UidAutoConfig {

    @Bean
    @ConditionalOnMissingBean
    UidService uidService() {
        return new UidServiceImpl();
    }

    @Bean
    public WorkerIdAssigner customWorkerIdAssigner() {

        return new WorkerIdAssigner() {
            @Override
            public long assignWorkerId() {
                // todo 根据MAC地址生成机器id
                return 3;
            }

            @Override
            public long assignFakeWorkerId() {
                return buildFakeWorkerNode().getId();
            }
        };
    }

    private WorkerNodeEntity buildFakeWorkerNode() {
        WorkerNodeEntity workerNodeEntity = new WorkerNodeEntity();
        workerNodeEntity.setType(WorkerNodeType.FAKE.value());
        if (DockerUtils.isDocker()) {
            workerNodeEntity.setHostName(DockerUtils.getDockerHost());
            workerNodeEntity.setPort(DockerUtils.getDockerPort() + "-" + RandomUtils.nextInt(100000));
        } else {
            workerNodeEntity.setHostName(NetUtils.getLocalAddress());
            workerNodeEntity.setPort(System.currentTimeMillis() + "-" + RandomUtils.nextInt(100000));
        }
        return workerNodeEntity;
    }
}
