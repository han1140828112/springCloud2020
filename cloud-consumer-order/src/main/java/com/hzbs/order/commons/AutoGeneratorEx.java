package com.hzbs.order.commons;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.ConstVal;
import com.baomidou.mybatisplus.generator.config.builder.ConfigBuilder;
import com.baomidou.mybatisplus.generator.config.po.TableField;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.File;
import java.util.List;
import java.util.Map;

/**
 * 生成代码扩展类
 * @author hk
 * @date 2018-10-31
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class AutoGeneratorEx extends AutoGenerator {

    public final static String IMPL = "impl";
    /**
     * 父包模块名。
     */
    private String moduleName = null;

    @Override
    protected List<TableInfo> getAllTableInfoList(ConfigBuilder config) {
        List<TableInfo> list = super.getAllTableInfoList(config);
        list.forEach(info -> {
            if(!info.isConvert() && !StrUtil.equals(info.getName(), info.getEntityName())) {
                info.setConvert(true);
            }
            List<TableField> fields = info.getFields();
            fields.forEach(field -> {
                if(!field.isConvert() && !StrUtil.equals(field.getName(), field.getPropertyName())) {
                    field.setConvert(true);
                }
            });
            info.setFields(fields);
        });
        if(StrUtil.isNotBlank(this.moduleName)) {
            Map<String, String> packageInfo = config.getPackageInfo();
            packageInfo.put(ConstVal.ENTITY, StrUtil.join(StringPool.DOT, packageInfo.get(ConstVal.ENTITY), this.moduleName));
            packageInfo.put(ConstVal.MAPPER, StrUtil.join(StringPool.DOT, packageInfo.get(ConstVal.MAPPER), this.moduleName));
            packageInfo.put(ConstVal.XML, StrUtil.join(StringPool.DOT, packageInfo.get(ConstVal.XML), this.moduleName));
            packageInfo.put(ConstVal.SERVICE, StrUtil.join(StringPool.DOT, packageInfo.get(ConstVal.SERVICE), this.moduleName));
            String serviceImpl = packageInfo.get(ConstVal.SERVICE_IMPL);
            if(serviceImpl.contains(IMPL))
                packageInfo.put(ConstVal.SERVICE_IMPL, StrUtil.replace(serviceImpl, IMPL, StrUtil.join(StringPool.DOT, this.moduleName, IMPL)));
            packageInfo.put(ConstVal.CONTROLLER, StrUtil.join(StringPool.DOT, packageInfo.get(ConstVal.CONTROLLER), this.moduleName));

            Map<String, String> configPathInfo = config.getPathInfo();
            configPathInfo.put(ConstVal.ENTITY_PATH, StrUtil.join(File.separator, configPathInfo.get(ConstVal.ENTITY_PATH), this.moduleName));
            configPathInfo.put(ConstVal.MAPPER_PATH, StrUtil.join(File.separator, configPathInfo.get(ConstVal.MAPPER_PATH), this.moduleName));
            configPathInfo.put(ConstVal.XML_PATH, StrUtil.join(File.separator, configPathInfo.get(ConstVal.XML_PATH), this.moduleName));
            configPathInfo.put(ConstVal.SERVICE_PATH, StrUtil.join(File.separator, configPathInfo.get(ConstVal.SERVICE_PATH), this.moduleName));
            String serviceImplPath = configPathInfo.get(ConstVal.SERVICE_IMPL_PATH);
            if(serviceImplPath.contains(IMPL)) {
                configPathInfo.put(ConstVal.SERVICE_IMPL_PATH, StrUtil.replace(serviceImplPath, IMPL, StrUtil.join(File.separator, this.moduleName, IMPL)));
            }
            configPathInfo.put(ConstVal.CONTROLLER_PATH, StrUtil.join(File.separator, configPathInfo.get(ConstVal.CONTROLLER_PATH), this.moduleName));
        }
        return list;
    }
}
