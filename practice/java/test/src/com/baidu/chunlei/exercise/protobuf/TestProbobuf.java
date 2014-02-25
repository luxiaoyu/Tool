package com.baidu.chunlei.exercise.protobuf;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;

/**
 * @author luxiaoyu01@baidu.com
 * @date 2014-1-26
 * @version
 * @todo
 */
public class TestProbobuf {

    private static void fillProto(CardProtoBuffer.Root.Builder rootBuilder) {
        CardProtoBuffer.Component.Builder componentBuilder = CardProtoBuffer.Component.newBuilder();
        componentBuilder.setType("TextView").setHeight(100).setWidth(100);// WRAP_CONTENT ????
        rootBuilder.addComponents(componentBuilder.build());
        rootBuilder.setType("").setHeight(100).setWidth(100)
                .addResource(getByteString("ic_launcher.png"));
    }

    private static ByteString getByteString(String fileName) {
        try {
            return ByteString.readFrom(new FileInputStream(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
//        CardProtoBuffer.Root.Builder rootBuilder = CardProtoBuffer.Root.newBuilder();
//        fillProto(rootBuilder);
//
//        ProtoBufferPractice.msgInfo.Builder builder = ProtoBufferPractice.msgInfo.newBuilder();
//        ByteString bs;
//        try {
//            bs = ByteString.readFrom(new FileInputStream("ic_launcher.png"));
//            builder.setID(1985).setGuid("Guid").setImage(bs);
//            builder.addPhoneNumber(5);
//            builder.addPhoneNumber(18);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        ProtoBufferPractice.msgInfo info = builder.build();

//        byte[] result = info.toByteArray();
//
//        ProtoBufferPractice.msgInfo msg;
//        try {
//            msg = ProtoBufferPractice.msgInfo.parseFrom(result);
//
//            FileOutputStream fos = new FileOutputStream("1.png");
//            fos.write(msg.getImage().toByteArray());
//            fos.close();
//            System.out.println(msg);
//        } catch (InvalidProtocolBufferException e) {
//            e.printStackTrace();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

}
