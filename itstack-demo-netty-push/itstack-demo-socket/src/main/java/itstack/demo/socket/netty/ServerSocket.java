package itstack.demo.socket.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * Created with IntelliJ IDEA.
 * User: fuzhengwei1
 * Date: 16-3-2
 * Time: 上午10:51
 * To change this template use File | Settings | File Templates.
 */
public class ServerSocket implements Runnable {

    private ChannelFuture f;

    /**
     * isActiveSocketServer
     *
     * @return boolean
     */
    public boolean isActiveSocketServer() {
        try {
            if (f != null) {
                return f.channel().isActive();
            } else {
                return false;
            }

        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 关闭Socket
     */
    public boolean doCloseSocket() {
        try {
            if (f != null) {
                if (isActiveSocketServer()) {
                    f.channel().close();
                    f = null;
                }
            }
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public void run() {

        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workGroup = new NioEventLoopGroup();

        try {
            ServerBootstrap b = new ServerBootstrap();

            b.group(bossGroup, workGroup);
            b.channel(NioServerSocketChannel.class);
            b.option(ChannelOption.SO_BACKLOG, 1024);

            b.childHandler(new ChildChannelHandler());
            // 端口可配
            f = b.bind(7397).sync();

            f.channel().closeFuture().sync();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            bossGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }

    }
}
