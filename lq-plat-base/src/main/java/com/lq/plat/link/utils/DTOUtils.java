package com.lq.plat.link.utils;

import com.lq.plat.link.utils.collect.Lists;
import org.joda.time.DateTime;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MappingContext;

import java.util.Date;
import java.util.List;

/**
 * @author 李强
 * @version 1.0.0
 * @date 2017/6/29
 */
public class DTOUtils {
    public static final ModelMapper INSTANCE = new ModelMapper();

    static {
        INSTANCE.addConverter(new DateTimeToDateConverter());
        INSTANCE.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    private static class DateTimeToDateConverter
            implements Converter<DateTime, Date> {
        public Date convert(MappingContext<DateTime, Date> context) {
            DateTime source = (DateTime) context.getSource();
            if (source != null) {
                return source.toDate();
            }
            return null;
        }
    }

    public static <S, T> T map(S source, Class<T> targetClass) {
        return (T) INSTANCE.map(source, targetClass);
    }

    public static <S, T> void map(S source, T dist) {
        INSTANCE.map(source, dist);
    }

    public static <S, T> List<T> map(List<S> source, Class<T> targetClass) {
        List<T> list = Lists.newArrayList(source.size());
        for (S obj : source) {
            T target = INSTANCE.map(obj, targetClass);
            list.add(target);
        }
        return list;
    }

}
