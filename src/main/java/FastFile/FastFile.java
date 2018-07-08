package FastFile;/**
 * Created by pc on 2018/7/7.
 */

import java.io.Serializable;

/**
 * describe:
 *
 * @author xxx
 * @date4 {YEAR}/07/07
 */
public class FastFile implements Serializable{
    public static final long serialVersion = 2637755431406080379L;
    //文件二进制
    private byte[] content;

    //文件名称
    private String name;

    //文件长度
    private long size;

    public FastFile() {
    }

    public FastFile(byte[] content, String name, long size) {
        this.content = content;
        this.name = name;
        this.size = size;
    }


    public static long getSerialVersion() {
        return serialVersion;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }
}
