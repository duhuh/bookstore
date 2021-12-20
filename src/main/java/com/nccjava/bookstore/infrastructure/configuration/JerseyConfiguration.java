package com.nccjava.bookstore.infrastructure.configuration;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.util.ClassUtils;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Path;
import javax.ws.rs.ext.Provider;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * Jersey 服务器配置
 * 前置路径为"restful"
 */
@Configuration
@ApplicationPath("/restful")
public class JerseyConfiguration extends ResourceConfig {

    public JerseyConfiguration() {
        scanPackages("com.nccjava.bookstore.resource");
        scanPackages("com.nccjava.bookstore.infrastructure.jaxrs");
    }

    /**
     * Jersey 的 packages() 方法在jar形式运行下有问题，修复一下
     * @param scanPackages
     */
    private void scanPackages(String scanPackages) {
        ClassPathScanningCandidateComponentProvider scanner = new ClassPathScanningCandidateComponentProvider(false);
        scanner.addIncludeFilter(new AnnotationTypeFilter(Path.class));
        scanner.addIncludeFilter(new AnnotationTypeFilter(Provider.class));
        this.registerClasses(scanner.findCandidateComponents(scanPackages).stream()
                .map(beanDefinition -> ClassUtils.resolveClassName(Objects.requireNonNull(beanDefinition.getBeanClassName()),this.getClassLoader()))
                .collect(Collectors.toSet()));
    }
}
