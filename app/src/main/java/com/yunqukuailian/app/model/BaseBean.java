package com.yunqukuailian.app.model;

/**
 * Created by Administrator on 2018/3/1/001.
 */

public class BaseBean {

    /**
     * map : {"result":1,"msg":"成功"}
     */

    private MapBean map;

    public MapBean getMap() {
        return map;
    }

    public void setMap(MapBean map) {
        this.map = map;
    }

    public static class MapBean {
        /**
         * result : 1
         * msg : 成功
         */

        private int result;
        private String msg;

        public int getResult() {
            return result;
        }

        public void setResult(int result) {
            this.result = result;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }
    }
}
