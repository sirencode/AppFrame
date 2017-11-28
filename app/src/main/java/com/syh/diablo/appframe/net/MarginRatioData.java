package com.syh.diablo.appframe.net;

/**
 * Created by yonghe.shen on 2017/11/27.
 */

public class MarginRatioData {
    /**
     * code : 0
     * errorMessage : OK
     * data : {"instrumentId":"DEFAULT_INSTRUMENT_ID","instrumentName":"默认保证金比率","marginRatio":0.5,"flag":"VIRTUAL","id":16,"exchangeId":null,"exchangeName":null}
     * ok : true
     */

    private int code;
    private String errorMessage;
    private DataBean data;
    private boolean ok;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public boolean isOk() {
        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }

    public static class DataBean {
        /**
         * instrumentId : DEFAULT_INSTRUMENT_ID
         * instrumentName : 默认保证金比率
         * marginRatio : 0.5
         * flag : VIRTUAL
         * id : 16
         * exchangeId : null
         * exchangeName : null
         */

        private String instrumentId;
        private String instrumentName;
        private double marginRatio;
        private String flag;
        private int id;
        private String exchangeId;
        private String exchangeName;

        public String getInstrumentId() {
            return instrumentId;
        }

        public void setInstrumentId(String instrumentId) {
            this.instrumentId = instrumentId;
        }

        public String getInstrumentName() {
            return instrumentName;
        }

        public void setInstrumentName(String instrumentName) {
            this.instrumentName = instrumentName;
        }

        public double getMarginRatio() {
            return marginRatio;
        }

        public void setMarginRatio(double marginRatio) {
            this.marginRatio = marginRatio;
        }

        public String getFlag() {
            return flag;
        }

        public void setFlag(String flag) {
            this.flag = flag;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getExchangeId() {
            return exchangeId;
        }

        public void setExchangeId(String exchangeId) {
            this.exchangeId = exchangeId;
        }

        public String getExchangeName() {
            return exchangeName;
        }

        public void setExchangeName(String exchangeName) {
            this.exchangeName = exchangeName;
        }
    }
}
