package com.lltech.llmall.entity;

import lombok.Data;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.List;

@Getter
@Data
public class CategoryVO {

    /**
     * 主键 分类id主键
     * -- GETTER --
     * 获取主键 分类id主键
     *
     * @return category_id - 主键 分类id主键
     */
    @Id
    @Column(name = "category_id")
    private Integer categoryId;

    /**
     * 分类名称 分类名称
     * -- GETTER --
     * 获取分类名称 分类名称
     *
     * @return category_name - 分类名称 分类名称
     */
    @Column(name = "category_name")
    private String categoryName;

    /**
     * 分类层级 分类得类型，
     * 1:一级大分类
     * 2:二级分类
     * 3:三级小分类
     * -- GETTER --
     * 获取分类层级 分类得类型，
     * 1:一级大分类
     * 2:二级分类
     * 3:三级小分类
     *
     * @return category_level - 分类层级 分类得类型，
     * 1:一级大分类
     * 2:二级分类
     * 3:三级小分类
     */
    @Column(name = "category_level")
    private Integer categoryLevel;

    /**
     * 父层级id 父id 上一级依赖的id，1级分类则为0，二级三级分别依赖上一级
     * -- GETTER --
     * 获取父层级id 父id 上一级依赖的id，1级分类则为0，二级三级分别依赖上一级
     *
     * @return parent_id - 父层级id 父id 上一级依赖的id，1级分类则为0，二级三级分别依赖上一级
     */
    @Column(name = "parent_id")
    private Integer parentId;

    /**
     * 图标 logo
     * -- GETTER --
     * 获取图标 logo
     *
     * @return category_icon - 图标 logo
     */
    @Column(name = "category_icon")
    private String categoryIcon;

    /**
     * 口号
     * -- GETTER --
     * 获取口号
     *
     * @return category_slogan - 口号
     */
    @Column(name = "category_slogan")
    private String categorySlogan;

    /**
     * 分类图
     * -- GETTER --
     * 获取分类图
     *
     * @return category_pic - 分类图
     */
    @Column(name = "category_pic")
    private String categoryPic;

    /**
     * 背景颜色
     * -- GETTER --
     * 获取背景颜色
     *
     * @return category_bg_color - 背景颜色
     */
    @Column(name = "category_bg_color")
    private String categoryBgColor;


    private List<CategoryVO> categories;
    /**
     * 设置主键 分类id主键
     *
     * @param categoryId 主键 分类id主键
     */
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * 设置分类名称 分类名称
     *
     * @param categoryName 分类名称 分类名称
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    /**
     * 设置分类层级 分类得类型，
     * 1:一级大分类
     * 2:二级分类
     * 3:三级小分类
     *
     * @param categoryLevel 分类层级 分类得类型，
     *                      1:一级大分类
     *                      2:二级分类
     *                      3:三级小分类
     */
    public void setCategoryLevel(Integer categoryLevel) {
        this.categoryLevel = categoryLevel;
    }

    /**
     * 设置父层级id 父id 上一级依赖的id，1级分类则为0，二级三级分别依赖上一级
     *
     * @param parentId 父层级id 父id 上一级依赖的id，1级分类则为0，二级三级分别依赖上一级
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * 设置图标 logo
     *
     * @param categoryIcon 图标 logo
     */
    public void setCategoryIcon(String categoryIcon) {
        this.categoryIcon = categoryIcon;
    }

    /**
     * 设置口号
     *
     * @param categorySlogan 口号
     */
    public void setCategorySlogan(String categorySlogan) {
        this.categorySlogan = categorySlogan;
    }

    /**
     * 设置分类图
     *
     * @param categoryPic 分类图
     */
    public void setCategoryPic(String categoryPic) {
        this.categoryPic = categoryPic;
    }

    /**
     * 设置背景颜色
     *
     * @param categoryBgColor 背景颜色
     */
    public void setCategoryBgColor(String categoryBgColor) {
        this.categoryBgColor = categoryBgColor;
    }
}

