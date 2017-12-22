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
		// ��ӡ����֧�ֵ��ַ���
		// printAllCharSet();
		// ����������
		encodeDecodeOperation();

	}
	// ����������
	private static void encodeDecodeOperation() throws CharacterCodingException {
		Charset latin1 = Charset.forName("ISO-8859-11");
		CharsetEncoder encoder = latin1.newEncoder();
		CharsetDecoder decoder = latin1.newDecoder();
		// ͨ�� CharBuffer �е� wrap() ��������һ���ַ�����Ϊ CharBuffer ����
		CharBuffer cb = CharBuffer.wrap("�ձ�С�Ϻ�����");
		ByteBuffer bb = encoder.encode(cb);
		System.out.println(decoder.decode(bb));
		// ע�⣺�����Ժ���"ISO-8859-1"�ı��뷽ʽ��ʾ���ģ������϶����޷�������ʾ�ģ�����֮��Ľ����������������룬һ��CharsetEncoder
		// ��CharsetDecoder ������ʹ�����ļ��Ķ�д�ϣ���ʵ���ļ������ת�����ܡ�
	}
	// ��ӡ����֧�ֵ��ַ���
	private static void printAllCharSet() {
		SortedMap<String, Charset> all = Charset.availableCharsets();
		Iterator<Map.Entry<String, Charset>> iterator = all.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry<String, Charset> mEntry = iterator.next();
			System.out.println(mEntry.getKey() + "--->" + mEntry.getValue());
		}
	}

}
