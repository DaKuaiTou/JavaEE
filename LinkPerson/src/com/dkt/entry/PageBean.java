package com.dkt.entry;

import java.util.List;

/**
 * @author: dkt
 * @Pcakage: com.dkt.entry.PageBean
 * @Date: 2022年10月18日 21:47
 * @Description:
 */
public class PageBean {
    // 总条数
    private Long totalSize;
    // 总页数
    private Long totalPage;
    // 当前页
    private Long currentPage;
    // 每页条数
    private Integer pageSize;
    // 当前页的数据集合
    private List<Person> personList;

    public PageBean() {
    }

    public PageBean(Long totalSize, Long totalPage, Long currentPage, Integer pageSize, List<Person> personList) {
        this.totalSize = totalSize;
        this.totalPage = totalPage;
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.personList = personList;
    }

    public Long getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(Long totalSize) {
        this.totalSize = totalSize;
    }

    public Long getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Long totalPage) {
        this.totalPage = totalPage;
    }

    public Long getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Long currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "totalSize=" + totalSize +
                ", totalPage=" + totalPage +
                ", currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                ", personList=" + personList +
                '}';
    }
}
