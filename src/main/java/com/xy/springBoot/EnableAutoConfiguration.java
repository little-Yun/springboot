package com.xy.springBoot;

/**
 * @EnableAutoConfiguration 注解加载SPRINGBOOT 自动配置
 */
public class EnableAutoConfiguration {

//    private static String FACTORIES_RESOURCE_LOCATION = "META-INF/spring.factories";
//
//    public String[] selectImports(AnnotationMetadata annotationMetadata) {
//        if (!isEnabled(annotationMetadata)) {
//            return NO_IMPORTS;
//        }
//        try {
//            AutoConfigurationMetadata autoConfigurationMetadata = AutoConfigurationMetadataLoader.loadMetadata(this.beanClassLoader);
//            AnnotationAttributes attributes = getAttributes(annotationMetadata);
//            // 获取候选配置的类路径
//            List<String> configurations = getCandidateConfigurations(annotationMetadata, attributes);
//            configurations = removeDuplicates(configurations);
//            configurations = sort(configurations, autoConfigurationMetadata);
//            Set<String> exclusions = getExclusions(annotationMetadata, attributes);
//            checkExcludedClasses(configurations, exclusions);
//            configurations.removeAll(exclusions);
//            configurations = filter(configurations, autoConfigurationMetadata);
//            fireAutoConfigurationImportEvents(configurations, exclusions);
//            return StringUtils.toStringArray(configurations);
//        }
//        catch (IOException ex) {
//            throw new IllegalStateException(ex);
//        }
//    }
//
//
//    protected List<String> getCandidateConfigurations(AnnotationMetadata metadata, AnnotationAttributes attributes) {
//        // 从SpringFactoriesLoader取候选配置的类路径
//        // 第一个参数getSpringFactoriesLoaderFactoryClass()得到的是EnableAutoConfiguration.class
//        List<String> configurations = SpringFactoriesLoader.loadFactoryNames(
//                getSpringFactoriesLoaderFactoryClass(), getBeanClassLoader());
//        Assert.notEmpty(configurations,
//                "No auto configuration classes found in META-INF/spring.factories. If you "
//                        + "are using a custom packaging, make sure that file is correct.");
//        return configurations;
//    }
//
//    //SpringFactoriesLoader.loadFactoryNames方法
//    public static List<String> loadFactoryNames(Class<?> factoryClass, @Nullable ClassLoader classLoader) {
//        // "org.springframework.boot.autoconfigure.EnableAutoConfiguration"
//        String factoryClassName = factoryClass.getName();
//        // 先调了下面的loadSpringFactories方法，得到一个Map
//        // 从Map中用EnableAutoConfiguration类的全限定名取一个String列表(其实也是一些类的全限定名列表)
//        return loadSpringFactories(classLoader).getOrDefault(factoryClassName, Collections.emptyList());
//    }
//
//
//    // 上面方法先从这里取了个Map
//    private static Map<String, List<String>> loadSpringFactories(@Nullable ClassLoader classLoader) {
//        // 这里有个缓存，记一下，后面会提到
//        MultiValueMap<String, String> result = cache.get(classLoader);
//        if (result != null)
//            return result;
//        try {
//            // FACTORIES_RESOURCE_LOCATION = "META-INF/spring.factories"
//            // 加载所有META-INF包下的spring.factories文件
//            Enumeration<URL> urls = (classLoader != null ?
//                    classLoader.getResources(FACTORIES_RESOURCE_LOCATION) :
//                    ClassLoader.getSystemResources(FACTORIES_RESOURCE_LOCATION));
//            result = new LinkedMultiValueMap<>();
//            while (urls.hasMoreElements()) {
//                URL url = urls.nextElement();
//                UrlResource resource = new UrlResource(url);
//                Properties properties = PropertiesLoaderUtils.loadProperties(resource);
//                for (Map.Entry<?, ?> entry : properties.entrySet()) {
//                    // 逗号分隔的String转为List
//                    List<String> factoryClassNames = Arrays.asList(
//                            StringUtils.commaDelimitedListToStringArray((String) entry.getValue()));
//                    result.addAll((String) entry.getKey(), factoryClassNames);
//                }
//            }
//            cache.put(classLoader, result);
//            return result;
//        }
//        catch (IOException ex) {
//            throw new IllegalArgumentException("Unable to load factories from location [" +  FACTORIES_RESOURCE_LOCATION + "]", ex);
//        }
//    }
}
