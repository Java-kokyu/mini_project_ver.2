package com.coffee.miniproject.common;

public class CacheKey {
    public static final int DEFAULT_EXPIRE_SEC = 60;
    public static final String USER = "user";
    public static final int USER_EXPIRE_SEC = 5 * 60;
    public static final String POSTS = "posts";
    public static final String POST = "post";
    public static final int POST_EXPIRE_SEC = 3 * 60;
    public static final String COMMENTS = "comments";
    public static final int COMMENTS_EXPIRE_SEC = 3 * 60;
}
