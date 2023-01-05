package xyz.xiashuo.springbootwebsimple.messageConverter;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;
import xyz.xiashuo.springbootwebsimple.domain.XiaShuoMessage;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * 参考 StringHttpMessageConverter
 * 仅支持 `XiaShuoMessage`类型的实例到`application/xs`（自定义`MediaType`）之间转化
 * 且还未支持读操作
 */
@Component
public class XiaShuoMessageConverter extends AbstractHttpMessageConverter<XiaShuoMessage> {
    // 默认编码
    public static final Charset DEFAULT_CHARSET = StandardCharsets.UTF_8;

    public XiaShuoMessageConverter() {
        // 仅支持 "application/xs" 类型的MediaType
        super(DEFAULT_CHARSET, MediaType.valueOf("application/xs"));
    }

    @Override
    protected boolean supports(Class<?> clazz) {
        // 只支持处理 XiaShuoMessage 类型的实例
        return XiaShuoMessage.class.isAssignableFrom(clazz);
    }

    @Override
    protected XiaShuoMessage readInternal(Class<? extends XiaShuoMessage> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        // 读操作有待实现
        return null;
    }

    @Override
    protected void writeInternal(XiaShuoMessage xiaShuoMessage, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        String content = myProtocolContent(xiaShuoMessage);
        // 输出到响应的消息体
        StreamUtils.copy(content, DEFAULT_CHARSET, outputMessage.getBody());
    }

    /**
     * 自定义消息输出内容格式
     *
     * @param xiaShuoMessage
     * @return
     */
    private String myProtocolContent(XiaShuoMessage xiaShuoMessage) {
        // 当然你可以在这里选择其他的拼接方式，比如把所有的属性用英文逗号拼接，等等。
        return xiaShuoMessage.toString();
    }

    @Override
    protected void addDefaultHeaders(HttpHeaders headers, XiaShuoMessage s, @Nullable MediaType type) throws IOException {
        // 不重写 addDefaultHeaders 指定响应的 ContentType 消息头的话，默认的addDefaultHeaders会自动设置 ContentType 为自定义 MediaType ：application/xs;charset=UTF-8，
        // 浏览器会处理不了，会变成下载，所以这里需要设置ContentType 消息头，设置成 MediaType.TEXT_PLAIN 是为了方便展示
        // 指定类型的时候指定编码
        headers.setContentType(new MediaType(MediaType.TEXT_PLAIN, DEFAULT_CHARSET));
        super.addDefaultHeaders(headers, s, type);
    }

    @Override
    protected Long getContentLength(XiaShuoMessage message, @Nullable MediaType contentType) {
        String str = myProtocolContent(message);
        return (long) str.getBytes(DEFAULT_CHARSET).length;
    }

}
