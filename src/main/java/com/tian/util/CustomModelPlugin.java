package com.tian.util;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.Method;
import org.mybatis.generator.api.dom.java.TopLevelClass;

import java.util.List;

public class CustomModelPlugin extends PluginAdapter {

    @Override
    public boolean validate(List<String> arg0) {
        return true;
    }

    @Override
    public boolean modelFieldGenerated(Field field,
                                       TopLevelClass topLevelClass, IntrospectedColumn introspectedColumn,
                                       IntrospectedTable introspectedTable, ModelClassType modelClassType) {

        List<String> doclist = field.getJavaDocLines();
        doclist.clear();
        doclist.add("/**");
        doclist.add(" * " + introspectedColumn.getRemarks());
        doclist.add(" * @mbggenerated");
        doclist.add(" */");
        return true;
    }

    @Override
    public boolean modelGetterMethodGenerated(Method method,
                                              TopLevelClass topLevelClass, IntrospectedColumn introspectedColumn,
                                              IntrospectedTable introspectedTable, ModelClassType modelClassType) {

        List<String> doclist = method.getJavaDocLines();
        doclist.clear();
        doclist.add("/**");
        doclist.add(" * " + introspectedColumn.getRemarks());
        doclist.add(" * @mbggenerated");
        doclist.add(" */");
        return true;
    }

    @Override
    public boolean modelSetterMethodGenerated(Method method,
                                              TopLevelClass topLevelClass, IntrospectedColumn introspectedColumn,
                                              IntrospectedTable introspectedTable, ModelClassType modelClassType) {

        List<String> doclist = method.getJavaDocLines();

        String paranName = method.getParameters().get(0).getName();

        doclist.clear();
        doclist.add("/**");
        doclist.add(" * " + introspectedColumn.getRemarks());
        doclist.add(" * @param " + paranName + " " + introspectedColumn.getRemarks());
        doclist.add(" * @mbggenerated");
        doclist.add(" */");

        return true;
    }


}
