package com.bench.bean;


public class S3Favorites implements java.io.Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;

    private Integer favoritesid;

    private Integer uid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getFavoritesid() {
        return favoritesid;
    }

    public void setFavoritesid(Integer favoritesid) {
        this.favoritesid = favoritesid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }
}