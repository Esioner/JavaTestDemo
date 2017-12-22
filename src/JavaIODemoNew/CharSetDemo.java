package JavaIODemoNew;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.util.Iterator;
import java.util.Map;
import java.util.SortedMap;

import org.apache.commons.lang.CharSet;

public class CharSetDemo {

	public static void main(String[] args) throws CharacterCodingException {
		// 打印所有支持的字符集
		// printAllCharSet();
		// 编码解码操作
		encodeDecodeOperation();

	}
	// 编码解码操作
	private static void encodeDecodeOperation() throws CharacterCodingException {
		Charset latin1 = Charset.forName("ISO-8859-11");
		CharsetEncoder encoder = latin1.newEncoder();
		CharsetDecoder decoder = latin1.newDecoder();
		// 通过 CharBuffer 中的 wrap() 方法，将一个字符串变为 CharBuffer 类型
		CharBuffer cb = CharBuffer.wrap("苏北小上海益林");
		ByteBuffer bb = encoder.encode(cb);
		System.out.println(decoder.decode(bb));
		// 注意：运行以后将以"ISO-8859-1"的编码方式显示中文，这样肯定是无法正常显示的，所以之后的解码操作都会造成乱码，一般CharsetEncoder
		// 和CharsetDecoder 都经常使用在文件的读写上，已实现文件编码的转换功能。
	}
	// 打印所有支持的字符集
	private static void printAllCharSet() {
		SortedMap<String, Charset> all = Charset.availableCharsets();
		Iterator<Map.Entry<String, Charset>> iterator = all.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry<String, Charset> mEntry = iterator.next();
			System.out.println(mEntry.getKey() + "--->" + mEntry.getValue());
		}
	}

}
