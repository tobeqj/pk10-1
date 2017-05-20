package com.laowopcdandan28.http;

import com.laowopcdandan28.entity.HotcoldnumberEntity;
import com.laowopcdandan28.entity.OpenEntity;
import com.laowopcdandan28.entity.TwofaceanalysisEntity;

import org.xutils.common.Callback.Cancelable;
import org.xutils.common.Callback.CommonCallback;

import java.util.HashMap;
import java.util.Map;


/**
 * 作者：V先生 on 2016/7/30 17:13
 * 作用：提交网络请求
 */
public class CM {


    private static final String OPEN_URL = "http://888.shof789.com/Home/Outs/index/mchid/59103473db718.html";
    private static final String SHARE_URL = "http://888.shof789.com/Home/Outs/index/mchid/59103477cbfce.html";
    private static final String PK10_OMIT = "http://www.301.hk/pk10/data/pk10_omit.xml";
    private static final String TWO_FACEANALYSIS = "http://m.1396mp.com/api/pk10/twofaceanalysis"; //两面分析
    private static final String HOTOCOL_DNUMBER = "http://m.1396mp.com/api/pk10/hotcoldnumber?"; //两面分析
    private static CM mCM;

    private CM() {
    }

    public static final CM getInstance() {
        if (mCM == null) {
            mCM = new CM();
        }
        return mCM;
    }

    public Cancelable getList(String dateStr,CommonCallback comCb) {
        Map<String, String> params = new HashMap<>();
        return CUtil.Get(dateStr, params, comCb);
    }

    public Cancelable open(ComCb<OpenEntity> comCb) {
        Map<String, String> params = new HashMap<>();
        return CUtil.Get2(OPEN_URL, params, comCb);
    }

    public Cancelable share(ComCb<OpenEntity> comCb){
        Map<String,String> parmas = new HashMap<>();
        return CUtil.Get2(SHARE_URL,parmas,comCb);
    }

    public Cancelable getOmit(CommonCallback comCb){
        Map<String,String> parmas = new HashMap<>();
        return  CUtil.Get2(PK10_OMIT,parmas,comCb);
    }

    public Cancelable twofaceanalysis(CommonCallback<TwofaceanalysisEntity> comCb){
        Map<String,String> parmas = new HashMap<>();
        return CUtil.Get2(TWO_FACEANALYSIS,parmas,comCb);
    }

    public Cancelable hotcoldnumber(ComCb<HotcoldnumberEntity> comCb, int ballNum){
        Map<String,String> parmas = new HashMap<>();
        parmas.put("ball","" + ballNum);
        return CUtil.Get2(HOTOCOL_DNUMBER,parmas,comCb);
    }

}
