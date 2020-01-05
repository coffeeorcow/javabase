package com.yi.temp.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import com.alibaba.fastjson.serializer.SerializeWriter;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CommonConfigSerializer implements ObjectSerializer {

    @Override
    public void write(JSONSerializer serializer, Object o, Object fieldName, Type type, int i) throws IOException {
        SerializeWriter out = serializer.out;

        if (o == null) {
            out.writeNull(SerializerFeature.WriteNullListAsEmpty);
        } else if (o instanceof Object[]) {
            // 将 CommonConfig 转换为 普通数组
            Object[] objs = (Object[]) o;
            List<Long> ids = new ArrayList<>();
            CommonConfig config;

            for (Object obj : objs) {
                if (!(obj instanceof CommonConfig)) {
                    out.write(JSON.toJSONString(o));
                    return;
                }
                config = (CommonConfig) obj;
                if (Objects.nonNull(config.getCommonId())) {
                    ids.add(config.getCommonId());
                }
            }

            out.write(JSON.toJSONString(ids));
        } else {
            out.write(JSON.toJSONString(o));
        }
    }

}
