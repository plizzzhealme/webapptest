package io.github.plizzzhealme.service;

public class ServiceFactory {

    private static SelectService selectServiceInstance;
    private static PostService postServiceInstance;

    private ServiceFactory() {

    }

    public static SelectService getSelectService(){
        if (selectServiceInstance == null) {
            selectServiceInstance = new SelectService();
        }

        return selectServiceInstance;
    }

    public static PostService getPostService(){
        if (postServiceInstance == null) {
            postServiceInstance = new PostService();
        }

        return postServiceInstance;
    }
}
