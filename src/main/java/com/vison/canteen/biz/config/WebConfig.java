package com.vison.canteen.biz.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author huangwenshen 2018/3/22 17:12
 */
@Configuration
@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter {

/*    @Value("${tmpLocation}")
    private String tmpLocation;

    @Bean
    MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setLocation(tmpLocation);
        return factory.createMultipartConfig();
    }*/

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/**");
    }


//
    //    @Bean
//    public MappingJackson2HttpMessageConverter getMappingJackson2HttpMessageConverter() {
//        MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
//        //设置日期格式
//        ObjectMapper objectMapper = new ObjectMapper();
//        SimpleDateFormat smt = new SimpleDateFormat("yyyy-MM-dd HH:mm");
//        objectMapper.setDateFormat(smt);
//        mappingJackson2HttpMessageConverter.setObjectMapper(objectMapper);
//        //设置中文编码格式
//        List<MediaType> list = new ArrayList<MediaType>();
//        list.add(MediaType.APPLICATION_JSON_UTF8);
//        mappingJackson2HttpMessageConverter.setSupportedMediaTypes(list);
//        return mappingJackson2HttpMessageConverter;
//    }
//    @Bean
//    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
//        MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
//        //设置日期格式
//        mappingJackson2HttpMessageConverter.setObjectMapper(
//                new ObjectMapper()
//                        .setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")));
////                        .setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE));
//        //设置中文编码格式
//        mappingJackson2HttpMessageConverter.setSupportedMediaTypes(new ArrayList<MediaType>() {
//            {
//                add(MediaType.APPLICATION_JSON_UTF8);
//            }
//        });
//        return mappingJackson2HttpMessageConverter;
//    }
//
//
//    @Autowired
//    private MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter;
//
//    @Bean
//    public ObjectMapper objectMapper() {
//        return mappingJackson2HttpMessageConverter.getObjectMapper();
//    }

//    @Override
//    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//        converters.add(mappingJackson2HttpMessageConverter);
//    }




}
