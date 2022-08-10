package com.hisun.kont.pg.utils;

import java.util.HashMap;
import java.util.Map;

//标注哪些报文的那些标签可以转中文
public class MTParseCodeConfig {
    //通过报文类型可以获取关系映射
    private static Map<String,Map> MT_MAP ;

    //根据需要配置多个报文的Map
    private static final Map<String,Map> MT103_MAP = new HashMap<String,Map>(){{
        put("50K",new HashMap<String,MapRule>(){{
            put("ordCustAddrList",new MapRule("List",0));
        }});
        put("50F",new HashMap<String,MapRule>(){{
            put("ordCustAddrList",new MapRule("List",0));
        }});
        put("51A",new HashMap<String,MapRule>(){{
            //51A没有使用
        }});
        put("52D",new HashMap<String,MapRule>(){{
            put("ordInstAddrList",new MapRule("List",1));
        }});
        put("53B",new HashMap<String,MapRule>(){{
            put("sndCorrAddr",new MapRule("String",0));
        }});
        put("53D",new HashMap<String,MapRule>(){{
            put("sndCorrAddrList",new MapRule("List",0));
        }});
        put("54B",new HashMap<String,MapRule>(){{
            put("rcvCorrBic",new MapRule("String",0));
        }});
        put("54D",new HashMap<String,MapRule>(){{
            put("rcvCorrAddrList",new MapRule("List",0));
        }});
        put("55B",new HashMap<String,MapRule>(){{
            put("reimInstAddr",new MapRule("String",0));
        }});
        put("55D",new HashMap<String,MapRule>(){{
            put("reimInstAddrList",new MapRule("List",0));
        }});
        put("56C",new HashMap<String,MapRule>(){{
            //只有一个标志人字段，不可转
        }});
        put("56D",new HashMap<String,MapRule>(){{
            put("medInstAddrList",new MapRule("List",0));
        }});
        put("57B",new HashMap<String,MapRule>(){{
            put("actInstAddr",new MapRule("String",0));
        }});
        put("57C",new HashMap<String,MapRule>(){{
            //只有一个关系人标识，不进行转换
        }});
        put("57D",new HashMap<String,MapRule>(){{
            put("actInstAddrList",new MapRule("List",0));
        }});
        put("59",new HashMap<String,MapRule>(){{
            put("benfCustAddrList",new MapRule("List",0));
        }});
        put("70",new HashMap<String,MapRule>(){{
            put("remitInfoList",new MapRule("List",0));
        }});
        put("72",new HashMap<String,MapRule>(){{
            put("srInfoList",new MapRule("List",0));
        }});
    }};

    //根据需要配置多个报文的Map
    private static final Map<String,Map> MT200_MAP = new HashMap<String,Map>(){{
        put("53B",new HashMap<String,MapRule>(){{
            put("sndCorrAddr",new MapRule("String",0));
        }});
        put("56D",new HashMap<String,MapRule>(){{
            put("medInstAddrList",new MapRule("List",0));
        }});
        put("57B",new HashMap<String,MapRule>(){{
            put("actInstAddr",new MapRule("String",0));
        }});
        put("57D",new HashMap<String,MapRule>(){{
            put("actInstAddrList",new MapRule("List",0));
        }});
        put("72",new HashMap<String,MapRule>(){{
            put("srInfoList",new MapRule("List",0));
        }});
    }};

    private static final Map<String,Map> MT192_MAP = new HashMap<String,Map>(){{
        put("79",new HashMap<String,MapRule>(){{
            put("narratList",new MapRule("List",0));
        }});
    }};

    private static final Map<String,Map> MT292_MAP = new HashMap<String,Map>(){{
        put("79",new HashMap<String,MapRule>(){{
            put("narratList",new MapRule("List",0));
        }});
    }};

    private static final Map<String,Map> MT199_MAP = new HashMap<String,Map>(){{
        put("79",new HashMap<String,MapRule>(){{
            put("narratList",new MapRule("List",0));
        }});
    }};

    private static final Map<String,Map> MT299_MAP = new HashMap<String,Map>(){{
        put("79",new HashMap<String,MapRule>(){{
            put("narratList",new MapRule("List",0));
        }});
    }};

    private static final Map<String,Map> MT999_MAP = new HashMap<String,Map>(){{
        put("79",new HashMap<String,MapRule>(){{
            put("narratList",new MapRule("List",0));
        }});
    }};

    private static final Map<String,Map> MT202_MAP = new HashMap<String,Map>(){{
        put("52D",new HashMap<String,MapRule>(){{
            put("ordInstAddrList",new MapRule("List",0));
        }});
        put("53B",new HashMap<String,MapRule>(){{
            put("sndCorrAddr",new MapRule("String",0));
        }});
        put("53D",new HashMap<String,MapRule>(){{
            put("sndCorrAddrList",new MapRule("List",0));
        }});
        put("54B",new HashMap<String,MapRule>(){{
            put("rcvCorrBic",new MapRule("String",0));
        }});
        put("54D",new HashMap<String,MapRule>(){{
            put("rcvCorrAddrList",new MapRule("List",0));
        }});
        put("56D",new HashMap<String,MapRule>(){{
            put("medInstAddrList",new MapRule("List",0));
        }});
        put("57B",new HashMap<String,MapRule>(){{
            put("actInstAddr",new MapRule("String",0));
        }});
        put("57D",new HashMap<String,MapRule>(){{
            put("actInstAddrList",new MapRule("List",0));
        }});
        put("58D",new HashMap<String,MapRule>(){{
            put("benfInstAddrList",new MapRule("List",0));
        }});
        put("72",new HashMap<String,MapRule>(){{
            put("srInfoList",new MapRule("List",0));
        }});
    }};



    public static Map<String,Map> getMap(){
        MT_MAP =new HashMap<String,Map>(){{
            put("MT103",MT103_MAP);
            put("MT200",MT200_MAP);
            put("MT202",MT202_MAP);
            put("MT192",MT192_MAP);
            put("MT292",MT292_MAP);
            put("MT199",MT199_MAP);
            put("MT299",MT299_MAP);
            put("MT999",MT999_MAP);

        }};
        return MT_MAP;
    }

    static class MapRule{
        private Map<String,Class> attrs;
        private String attrClazz;
        //只与list属性绑定，若list第一行不允许转，则传入evitLine置为1‘
        //attrClazz为String时同意置为0
        private Integer evitLine;
        MapRule(String attrClazz , Integer evitLine){
            this.attrClazz=attrClazz;
            this.evitLine=evitLine;
        }

        public Map<String, Class> getAttrs() {
            return attrs;
        }

        public void setAttrs(Map<String, Class> attrs) {
            this.attrs = attrs;
        }

        public String getAttrClazz() {
            return attrClazz;
        }

        public void setAttrClazz(String attrClazz) {
            this.attrClazz = attrClazz;
        }

        public Integer getEvitLine() {
            return evitLine;
        }

        public void setEvitLine(Integer evitLine) {
            this.evitLine = evitLine;
        }
    }
}
