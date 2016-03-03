package itstack.demo.socket.netty;

import java.nio.charset.Charset;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

public class ChildChannelHandler extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel e) throws Exception {

        // 基于换行符号
        e.pipeline().addLast(new LineBasedFrameDecoder(1024));
        // 解码转 String
        e.pipeline().addLast(new StringDecoder(Charset.forName("GBK")));
        // 编码器 String
        e.pipeline().addLast(new StringEncoder(Charset.forName("GBK")));
        // 在管道中添加我们自己的接收数据实现方法
        e.pipeline().addLast(new MyServerHandLer());

    }

}
