package mybatisPlusCodeGenerateTest;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.google.common.collect.Lists;
import com.hzbs.payment.commons.AutoGeneratorEx;
import org.junit.Ignore;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenerateCodeTests {

    private final static String JDBC_URL = "jdbc:mysql://localhost:3306/springcloud2020";
    private final static String JDBC_USER = "root";
    private final static String JDBC_PASS = "wang";
    private final static String MODULE_SINGLE = "";
    private final static String MODULE_MULTI = "pm";
    private final static String[] TABLES = {"payment"};
    private final static String LOGIC_DELETE_FIELD_NAME = "ddd_is_delete";

    @Test
//    @Ignore
    public void generateSingleCode() {
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        //执行完成后是否自动打开文件夹
        //gc.setOpen(false);
        //生成的路径，需要改为自己的生成路径
        String baseDic = "/Users/wangxuehui/Desktop/generateCode";
        gc.setOutputDir(baseDic);
        gc.setFileOverride(true);
        gc.setActiveRecord(true);
        gc.setEnableCache(false);// XML 二级缓存
        gc.setBaseResultMap(true);// XML ResultMap
        gc.setBaseColumnList(false);// XML columList
        gc.setAuthor("Mr.wxh");

        // 自定义文件命名，注意 %s 会自动填充表实体属性！
        gc.setMapperName("I%sDao");
        gc.setXmlName("%sMapper");
        gc.setServiceName("I%sManager");
        gc.setServiceImplName("%sManagerImpl");
        gc.setControllerName("%sAct");
        gc.setIdType(IdType.UUID);
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setTypeConvert(new MySqlTypeConvert());
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername(JDBC_USER);
        dsc.setPassword(JDBC_PASS);
        dsc.setUrl(JDBC_URL+"?useUnicode=true&characterEncoding=utf8&useSSL=false&tinyInt1isBit=true");
        mpg.setDataSource(dsc);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        //strategy.setCapitalMode(true);// 全局大写命名 ORACLE 注意
        //strategy.setTablePrefix(new String[] { "bim_"});// 此处可以修改为您的表前缀

        strategy.setNaming(NamingStrategy.underline_to_camel);// 表名生成策略
        strategy.setInclude(TABLES); // 需要生成的表

        //strategy.setExclude(new String[]{"sys_user_role","sys_role_menu","sys_group_ur"}); // 排除生成的表
        // 自定义实体父类
        //strategy.setSuperEntityClass("com.mysiteforme.admin.base.DataEntity");
        // 自定义实体，公共字段
        //strategy.setSuperEntityColumns(new String[]{"id", "create_date", "create_by", "update_date", "update_by", "remarks", "del_flag"});
        //strategy.setSuperEntityColumns(new String[] { "id" });
        // 自定义 mapper 父类
        // strategy.setSuperMapperClass("com.baomidou.demo.TestMapper");
        // 自定义 service 父类
        // strategy.setSuperServiceClass("com.baomidou.demo.TestService");
        // 自定义 service 实现类父类
        // strategy.setSuperServiceImplClass("com.baomidou.demo.TestServiceImpl");
        // 自定义 controller 父类
        // strategy.setSuperControllerClass("com.baomidou.demo.TestController");
        // 【实体】是否生成字段常量（默认 false）
        // public static final String ID = "test_id";
        strategy.setEntityColumnConstant(true);
        // 【实体】是否为lombok模型（默认 false）
        strategy.setEntityLombokModel(true);
        // 【实体】是否为构建者模型（默认 false）
        // public User setName(String name) {this.name = name; return this;}
        // strategy.setEntityBuliderModel(true);
        // 是否生成实体时，生成字段注解
        strategy.entityTableFieldAnnotationEnable(true);
        strategy.setLogicDeleteFieldName(LOGIC_DELETE_FIELD_NAME);
        //strategy.setLogicDeleteFieldName("ubi_is_delete");
        //strategy.setLogicDeleteFieldName("csi_is_delete");

        mpg.setStrategy(strategy);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.hzbs.payment."+MODULE_SINGLE);
        //pc.setModuleName("basic");
        pc.setMapper("dao");
        pc.setXml("mapper");
        pc.setService("manager");
        pc.setServiceImpl("manager.impl");
        pc.setController("action");
        mpg.setPackageInfo(pc);

//        // 注入自定义配置，可以在 VM 中使用 cfg.abc 【可无】
//        InjectionConfig cfg = new InjectionConfig() {
//            @Override
//            public void initMap() {
//                Map<String, Object> map = new HashMap<String, Object>();
//                map.put("abc", this.getConfig().getGlobalConfig().getAuthor() + "-mp");
//                this.setMap(map);
//            }
//        };
//        // 自定义 xxList.jsp 生成
//        List<FileOutConfig> focList = Lists.newArrayList();
//        focList.add(new FileOutConfig("/templates/vm/list.jsp.vm") {
//            @Override
//            public String outputFile(TableInfo tableInfo) {
//                // 自定义输入文件名称
//                return baseDic+ "/"  + tableInfo.getEntityPath() + "/list.ftl";
//            }
//        });
//        focList.add(new FileOutConfig("/templates/vm/add.jsp.vm") {
//            @Override
//            public String outputFile(TableInfo tableInfo) {
//                // 自定义输入文件名称
//                return baseDic+ "/" + tableInfo.getEntityPath() + "/add.ftl";
//            }
//        });
//        focList.add(new FileOutConfig("/templates/vm/edit.jsp.vm") {
//            @Override
//            public String outputFile(TableInfo tableInfo) {
//                // 自定义输入文件名称
//                return baseDic+ "/"  + tableInfo.getEntityPath() + "/edit.ftl";
//            }
//        });
//        cfg.setFileOutConfigList(focList);
//        mpg.setCfg(cfg);
        //mpg.setTemplateEngine(new FreemarkerTemplateEngine());

        // 自定义模板配置，可以 copy 源码 mybatis-plus/src/main/resources/template 下面内容修改，
        // 放置自己项目的 src/main/resources/template 目录下, 默认名称一下可以不配置，也可以自定义模板名称
        TemplateConfig tc = new TemplateConfig();
        /*tc.setEntity("/templates/vm/entity.java.vm");
        tc.setService("/templates/vm/service.java.vm");
        tc.setServiceImpl("/templates/vm/serviceImpl.java.vm");
        //tc.setController("/templates/vm/controller.java.vm");
        tc.setMapper("/templates/vm/mapper.java.vm");*/
        // 如上任何一个模块如果设置 空 OR Null 将不生成该模块。
        // 关闭默认 xml 生成，调整生成 至 根目录
        //tc.setXml(null);
        mpg.setTemplate(tc);

        // 执行生成
        mpg.execute();
    }


    @Test
    @Ignore
    public void generateMultiModelCode() {

        AutoGeneratorEx mpg = new AutoGeneratorEx();
        mpg.setModuleName(MODULE_MULTI);

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        //执行完成后是否自动打开文件夹
        //gc.setOpen(false);
        String baseDic = "D://yld";
        gc.setOutputDir(baseDic);
        gc.setFileOverride(true);
        gc.setActiveRecord(true);
        gc.setEnableCache(false);// XML 二级缓存
        gc.setBaseResultMap(true);// XML ResultMap
        gc.setBaseColumnList(false);// XML columList
        gc.setAuthor("zhang yang ze");

        // 自定义文件命名，注意 %s 会自动填充表实体属性！
        gc.setMapperName("I%sDao");
        gc.setXmlName("%sMapper");
        gc.setServiceName("I%sManager");
        gc.setServiceImplName("%sManagerImpl");
        gc.setControllerName("%sAct");
        gc.setIdType(IdType.UUID);
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setTypeConvert(new MySqlTypeConvert());
        dsc.setDriverName("com.mysql.jdbc.Driver");
        dsc.setUsername(JDBC_USER);
        dsc.setPassword(JDBC_PASS);
        dsc.setUrl(JDBC_URL+"?useUnicode=true&characterEncoding=utf8&useSSL=false&tinyInt1isBit=true&allowPublicKeyRetrieval=true");
        mpg.setDataSource(dsc);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        //strategy.setCapitalMode(true);// 全局大写命名 ORACLE 注意
        //strategy.setTablePrefix(new String[] { "bim_"});// 此处可以修改为您的表前缀

        strategy.setNaming(NamingStrategy.underline_to_camel);// 表名生成策略
        strategy.setInclude(TABLES); // 需要生成的表

        //strategy.setExclude(new String[]{"sys_user_role","sys_role_menu","sys_group_ur"}); // 排除生成的表
        // 自定义实体父类
        //strategy.setSuperEntityClass("com.mysiteforme.admin.base.DataEntity");
        // 自定义实体，公共字段
        //strategy.setSuperEntityColumns(new String[]{"id", "create_date", "create_by", "update_date", "update_by", "remarks", "del_flag"});
        //strategy.setSuperEntityColumns(new String[] { "id" });
        // 自定义 mapper 父类
        // strategy.setSuperMapperClass("com.baomidou.demo.TestMapper");
        // 自定义 service 父类
        // strategy.setSuperServiceClass("com.baomidou.demo.TestService");
        // 自定义 service 实现类父类
        // strategy.setSuperServiceImplClass("com.baomidou.demo.TestServiceImpl");
        // 自定义 controller 父类
        // strategy.setSuperControllerClass("com.baomidou.demo.TestController");
        // 【实体】是否生成字段常量（默认 false）
        // public static final String ID = "test_id";
        strategy.setEntityColumnConstant(true);
        // 【实体】是否为lombok模型（默认 false）
        strategy.setEntityLombokModel(true);
        // 【实体】是否为构建者模型（默认 false）
        // public User setName(String name) {this.name = name; return this;}
        // strategy.setEntityBuliderModel(true);
        // 是否生成实体时，生成字段注解
        strategy.entityTableFieldAnnotationEnable(true);
        strategy.setLogicDeleteFieldName(LOGIC_DELETE_FIELD_NAME);

        mpg.setStrategy(strategy);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("cn.com.yyxx.yld."+MODULE_SINGLE);
        pc.setMapper("dao");
        pc.setXml("mapper");
        pc.setService("manager");
        pc.setServiceImpl("manager.impl");
        pc.setController("action");
        mpg.setPackageInfo(pc);

        // 注入自定义配置，可以在 VM 中使用 cfg.abc 【可无】
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("abc", this.getConfig().getGlobalConfig().getAuthor() + "-mp");
                this.setMap(map);
            }
        };
        // 自定义 xxList.jsp 生成
        List<FileOutConfig> focList = Lists.newArrayList();
        focList.add(new FileOutConfig("/templates/vm/list.jsp.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输入文件名称
                return baseDic+ "/"  + tableInfo.getEntityPath() + "/list.ftl";
            }
        });
        focList.add(new FileOutConfig("/templates/vm/add.jsp.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输入文件名称
                return baseDic+ "/" + tableInfo.getEntityPath() + "/add.ftl";
            }
        });
        focList.add(new FileOutConfig("/templates/vm/edit.jsp.vm") {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输入文件名称
                return baseDic+ "/"  + tableInfo.getEntityPath() + "/edit.ftl";
            }
        });
        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);
        //mpg.setTemplateEngine(new FreemarkerTemplateEngine());

        // 自定义模板配置，可以 copy 源码 mybatis-plus/src/main/resources/template 下面内容修改，
        // 放置自己项目的 src/main/resources/template 目录下, 默认名称一下可以不配置，也可以自定义模板名称
        TemplateConfig tc = new TemplateConfig();
        /*tc.setEntity("/templates/vm/entity.java.vm");
        tc.setService("/templates/vm/service.java.vm");
        tc.setServiceImpl("/templates/vm/serviceImpl.java.vm");
        //tc.setController("/templates/vm/controller.java.vm");
        tc.setMapper("/templates/vm/mapper.java.vm");*/
        // 如上任何一个模块如果设置 空 OR Null 将不生成该模块。
        // 关闭默认 xml 生成，调整生成 至 根目录
        //tc.setXml(null);
        mpg.setTemplate(tc);

        // 执行生成
        mpg.execute();
    }
}

