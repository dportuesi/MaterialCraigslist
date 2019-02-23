package com.domenicportuesi.materialcraigslist.activity.categories;

public class CategoryItem
{
    private String name;
    private int categoryCount;

    public CategoryItem(String name, int categoryCount)
    {
        this.name = name;
        this.categoryCount = categoryCount;
    }
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getCategoryCount()
    {
        return categoryCount;
    }

    public void setCategoryCount(int categoryCount)
    {
        this.categoryCount = categoryCount;
    }

}
