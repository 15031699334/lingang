package com.boot.gang.util;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Value;

import javax.servlet.ServletOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.*;
import java.util.List;


public class PdfUtil {
    public static int tableHeight;


    /**
     * 生成 pdf图片
     *
     * @param map
     * @param hNum
     * @param gongzhangPath
     * @param outputStream
     * @param hadGZ
     * @throws FileNotFoundException
     */
    public static void exportPdf1(Map<String, Object> map, int hNum, String gongzhangPath, ServletOutputStream outputStream, boolean hadGZ) {

    }


    /**
     * 生成pdf
     *
     * @param map           参数
     * @param hNum
     * @param gongzhangPath 公章路径
     * @param outputStream
     * @param hadGZ         true= 有公章 false=无公章
     */
    public static void exportPdf(Map<String, Object> map, int hNum, String gongzhangPath, ServletOutputStream outputStream, boolean hadGZ) {
        Document document = new Document(PageSize.A4);
        try {
            PdfWriter writer = PdfWriter.getInstance(document, outputStream);
            // 导入数据
            insertPDFIo(map, hNum, gongzhangPath, outputStream, hadGZ, document);
            document.close();
            writer.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * pdf 添加数据
     *
     * @param map
     * @param hNum
     * @param gongzhangPath
     * @param outputStream
     * @param hadGZ
     * @param document
     * @return
     * @throws Exception
     */
    private static Document insertPDFIo(Map<String, Object> map, int hNum, String gongzhangPath, ServletOutputStream outputStream, boolean hadGZ, Document document) throws Exception {
        //参数区
        String name = map.get("name") == null ? "未设置公司及负责人名称" : map.get("name").toString();
        String orderNo = map.get("orderNo") == null ? "" : map.get("orderNo").toString();
        String address = map.get("address") == null ? "测试地址" : map.get("address").toString();
        String createTime = map.get("createTime") == null ? "2020-01-17" : map.get("createTime").toString();
        //提货地点
        String pickUpAddress = map.get("pickUpAddress") == null ? "北京" : map.get("pickUpAddress").toString();
        //提货方式
        String pickUpType = map.get("pickUpType") == null ? "北京" : map.get("pickUpType").toString();
        //运货
        String freightType = map.get("freightType") == null ? "汽运" : map.get("freightType").toString();
        //        //运费支付方式
        String freightFeePayType = map.get("freightFeePayType") == null ? "自动支付" : map.get("freightFeePayType").toString();
        //目的地
        String freightAddress = map.get("freightAddress") == null ? "北京" : map.get("freightAddress").toString();
        // 剪切尺寸与方式
        String cutType = map.get("cutType") == null ? "----" : map.get("cutType").toString();

        List<List<String>> list = (List<List<String>>) map.get("productDetail");
        if (list == null) {
            list = createTestList();
        }

        document.open();
        BaseFont bf = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
        Font fontChinese = new Font(bf, 16, Font.NORMAL);
        Font bodyChinese = new Font(bf, 9, Font.NORMAL);
          /*  Paragraph paragraph = new Paragraph("供需合同", fontChinese);
            paragraph.setAlignment(1);
            document.add(paragraph);*/
        Paragraph paragraph = new Paragraph();

        document.add(addBiaoTi(fontChinese, bodyChinese, "供需合同", "合同编号: " + orderNo));
        document.add(addYeTou(bodyChinese, "供方(甲方): 山东临钢电子商务股份有限公司", "合同编号: " + orderNo, "需方(乙方): " + name, "签约地点: " + address, "签约时间: " + createTime));
            /*document.add(addFirst(bodyChinese,orderNo));
            document.add(addTwo(bodyChinese, name, address));
            document.add(addThree(bodyChinese, createTime));*/
        document.add(addString(bodyChinese, "为确保买卖双方双方的共同利益实现互利双赢的目的，根据《中华人民共和国合同法》之规定，经供需双方充分协商" +
                "特订立此合同以便共同遵守。"));
        document.add(addString(bodyChinese, "一、 货物明细"));
        // 商品内容
        document.add(addTable(bodyChinese, list));
        document.add(addString(bodyChinese, "二、质量标准：按产品对应钢厂的现行牌号产品对应的标准执行。"));
        //提货方式
        paragraph.add(new Chunk("三、<交提>货地点：", bodyChinese));
        paragraph.add(undefinedString(bodyChinese, pickUpAddress));
        paragraph.add(new Chunk("          提货方式：", bodyChinese));
        paragraph.add(undefinedString(bodyChinese, pickUpType));
        document.add(paragraph);
        //运货方式
        paragraph = new Paragraph();
        paragraph.add(new Chunk("四、运货方式：", bodyChinese));
        paragraph.add(undefinedString(bodyChinese, freightType));
        paragraph.add(new Chunk("      运费支付：", bodyChinese));
        paragraph.add(undefinedString(bodyChinese, freightFeePayType));
        paragraph.add(new Chunk("      目的地：", bodyChinese));
        paragraph.add(undefinedString(bodyChinese, freightAddress));
        document.add(paragraph);

        document.add(addString(bodyChinese, "五、验收标准及异议处理："));
        document.add(addString(bodyChinese, "1、重量验收标准：按供方出库单记录为结算重量。"));
        document.add(addString(bodyChinese, "2、数量异议处理：双方约定，过磅抄码计重，磅差执行国标±3‰ ,若超出±3‰原产品封存复磅。"));
        document.add(addString(bodyChinese, "3、质量异议处理：需方于收货后7日内以书面形式向供方提出异议，并将原产品封存，供方根据钢厂质量保证书及钢厂代表现场勘查情况处理相关质量问题，逾期供方不承担任何责任。"));
        document.add(addString(bodyChinese, "六、付款方式及期限："));
        document.add(addString(bodyChinese, "1、需方按照平台规则在平台拍到产品后，需在两小时内把全额货款汇到供方指定账户（以供方进账时间为准），款到账后合同生效，提货后由供方向需方开具全额增值税发票。"));
        document.add(addString(bodyChinese, "2、供需双方约定以人民币为结算货币，可通过电汇、现金、银行承兑汇票等结算方式进行付款。实际结算金额按需方实提进行货款多退少补；"));
        document.add(addString(bodyChinese, "3、如果需方未按合同约定付清款项，供方有权处理所有货物，此客户不再享有锁货权利。"));
        //剪切尺寸及方式
            /*paragraph = new Paragraph();
            paragraph.add(new Chunk("七、剪切尺寸及方式：", bodyChinese));
            paragraph.add(undefinedString(bodyChinese, cutType));
            document.add(paragraph);*/
        document.add(addString(bodyChinese, "七、合同生效及解除方式：需方按时支付货款后合同生效，本合同一式两份，双方各执壹份，传真件具有同等法律效力，供需双方钱货两清后合同自然解除。"));
        document.add(addString(bodyChinese, "八、争议及解决办法：本合同在执行过程中，如发生争议，应由供需双方友好协商解决。如协商不能解决，可向供方" +
                "所在地法院提起诉讼，依法追究违约方责任。"));

        Map<String, String> secondInfoMap = (Map<String, String>) map.get("secondInfo");
        if (secondInfoMap == null) {
            secondInfoMap = new HashMap<>();
            secondInfoMap.put("name", "临钢网");
            secondInfoMap.put("address", "临钢网");
            secondInfoMap.put("phone", "临钢网");
            secondInfoMap.put("fax", "临钢网");
            secondInfoMap.put("openBank", "临钢网");
            secondInfoMap.put("bankCode", "临钢网");
            secondInfoMap.put("signature", "临钢网");
        }
        document.add(addTailTable(bodyChinese, secondInfoMap));
        if (hadGZ) {
            document.add(addImages(gongzhangPath, hNum));
        }

//        if (document.getPageNumber() == 1) {
//
//        }

        document.add(addString(bodyChinese, "注:以上横线处内容手写或涂改无效。"));

        return document;
    }

    private static List<List<String>> createTestList() {
        List<String> headerList = new ArrayList<>();
        headerList.add("测试");
        headerList.add("测试");
        headerList.add("测试");
        headerList.add("测试");
        headerList.add("测试");
        headerList.add("测试");
        headerList.add("测试");
        headerList.add("测试");
        List<List<String>> list = new ArrayList<>();
        list.add(headerList);
        list.add(headerList);
        list.add(headerList);
        list.add(headerList);
        list.add(headerList);
        list.add(headerList);
        list.add(headerList);
        list.add(headerList);
        list.add(headerList);
        list.add(headerList);
        list.add(headerList);
        return list;
    }

    private static Element addImages(String imagePath, int hNum) throws IOException, BadElementException {

//        System.out.println("T1 Heiget: " + PdfUtil.tableHeight);
        // 361 >= 货物明细表高度 > 245 时, 供需方信息表恰好在第二页起始位置
        // 供需方信息表固定高为 116

        //根据路径读取图片
        Image image = Image.getInstance(imagePath);
        //获取图片页面
        //图片大小自适应
        image.scaleToFit(100, 100);
        //添加图片
        int pageHeigh = 842;//每页标准高
        int headFoot=32;//页眉页脚高
        int wordsTop =150 ;//顶部文字高
        int wordsMid=267;// 中部文字高
        int footTable=116;//底部表格
        int th = PdfUtil.tableHeight;
        int zhY = 0;



        if (PdfUtil.tableHeight <= 245) {    // 表格在第一页
            image.setAbsolutePosition(195, pageHeigh-headFoot-wordsTop-wordsMid-th-50);
        } else if (PdfUtil.tableHeight > 245 && PdfUtil.tableHeight <= 361){    // 表格恰好在第二页
            image.setAbsolutePosition(195, 720);
        } else {
            image.setAbsolutePosition(195, pageHeigh - wordsMid + (pageHeigh-headFoot-wordsTop-th)-headFoot-footTable);
        }



//            image.setAbsolutePosition(195, zhY);
        return image;
    }

    private static Element addTailTable(Font bodyChinese, Map<String, String> secondInfoMap) throws DocumentException {
        // 表格类
        int column = 2;
        int row = 7;
        PdfPTable table = new PdfPTable(column);
        table.setSpacingBefore(10f);
        // 设置表格下面空白宽度
//        table.setSpacingAfter(10f);
        float tatalWidth = 500;
        int size = 2;
        float width[] = new float[size];
        for (int i = 0; i < size; i++) {
            if (i == 0) {
                width[i] = 260f;
            } else {
                width[i] = 230f;
            }
        }
        table.setTotalWidth(width);
        table.setLockedWidth(true);
        table.setKeepTogether(true);
        table.setSplitLate(false);
        table.setSplitRows(true);
        //表格数据填写
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                Paragraph paragraph = null;
                if (j == 0) {
                    if (i == 0) {
                        paragraph = new Paragraph("供方：山东临钢电子商务股份有限公司", bodyChinese);
                    } else if (i == 1) {
                        paragraph = new Paragraph("地址：临沂市经济开发区沂蒙云谷B座6层", bodyChinese);
                    } else if (i == 2) {
                        paragraph = new Paragraph("电话：0539-6387606", bodyChinese);
                    } else if (i == 3) {
                        paragraph = new Paragraph("传真：0539-6387608", bodyChinese);
                    } else if (i == 4) {
                        paragraph = new Paragraph("开户行：中国农业银行股份有限公司临沂经济技术开发区支行", bodyChinese);
                    } else if (i == 5) {
                        paragraph = new Paragraph("账号： 15873201045555669", bodyChinese);
                    } else if (i == 6) {
                        paragraph = new Paragraph("委托代理人签字：", bodyChinese);
                    }
                } else {
                    if (i == 0) {
                        paragraph = new Paragraph("需方：" + (secondInfoMap.get("name") == null ? "未设置公司及负责人名称" : secondInfoMap.get("name").toString()), bodyChinese);
                    } else if (i == 1) {
                        paragraph = new Paragraph("地址：" + secondInfoMap.get("address"), bodyChinese);
                    } else if (i == 2) {
                        paragraph = new Paragraph("电话：" + secondInfoMap.get("phone"), bodyChinese);
                    } else if (i == 3) {
                        paragraph = new Paragraph("传真：" + secondInfoMap.get("fax"), bodyChinese);
                    } else if (i == 4) {
                        paragraph = new Paragraph("开户行：" + secondInfoMap.get("openBank"), bodyChinese);
                    } else if (i == 5) {
                        paragraph = new Paragraph("账号： " + secondInfoMap.get("bankCode"), bodyChinese);
                    } else if (i == 6) {
                        paragraph = new Paragraph("委托代理人签字：" + secondInfoMap.get("signature"), bodyChinese);
                    }
                }
                PdfPCell cell = new PdfPCell(paragraph);
//                cell.setVerticalAlignment(Element.ALIGN_CENTER);
//                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setLeading(0, (float) 1.4);
//                cell.setFixedHeight(16);
                table.addCell(cell);
            }

        }
        table.setSplitLate(false);
//        PdfUtil.tableHeight=(int)table.getTotalHeight();
//        System.out.println("T2表格高度: "+PdfUtil.tableHeight);
        return table;
    }

    private static Chunk undefinedString(Font bodyChinese, String pickUpAddress) {
        Chunk chunk = new Chunk(pickUpAddress, bodyChinese);
        chunk.setUnderline(0.2f, -2f);
        return chunk;
    }

    private static Element addTable(Font bodyChinese, List<List<String>> tableList) throws DocumentException {
        // 表格类
        int column = tableList.get(0).size();
        int row = tableList.size();
        PdfPTable table = new PdfPTable(column);
        table.setSpacingBefore(10f);
        // 设置表格下面空白宽度
//        table.setSpacingAfter(10f);
        float tatalWidth = 500;
        int size = tableList.get(0).size();
        float width[] = new float[size];
        for (int i = 0; i < size; i++) {
            if (i == 0) {
                width[i] = 30f;
            } else if (i == 3 || i == 8) {
                width[i] = 60f;
            } else if (i == 4) {
                width[i] = 70f;
            } else if (i == 6) {
                width[i] = 100f;
            } else {
                width[i] = (tatalWidth - 260) / (size - 5);
            }
        }
        table.setTotalWidth(width);
        table.setLockedWidth(true);
        table.setKeepTogether(false);
        table.setSplitLate(false);
        table.setSplitRows(true);
        //表格数据填写
        for (int i = 0; i < row; i++) {
            if (i >= row - 3) {      // 倒数第二行    价格77.77
                String price = tableList.get(i).get(0);
                BaseFont bf1 = null;
                try {
//                    bf1 = BaseFont.createFont("C:\\Windows\\Fonts\\simfang.ttf",BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
                    bf1 = BaseFont.createFont("/usr/share/fonts/simfang.ttf", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Font priceChinese = new Font(bf1, 10, Font.NORMAL, null);
                Paragraph paragraph = new Paragraph(price, priceChinese);
                PdfPCell cell = new PdfPCell(paragraph);
                cell.setColspan(9);
                cell.setVerticalAlignment(Element.ALIGN_CENTER);
                cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                cell.setLeading(0, (float) 1.4);
//                cell.setFixedHeight(16);
                table.addCell(cell);
                continue;
            }
            List<String> list = tableList.get(i);
            Collections.replaceAll(list, "0.0*0*0", "-------");
            for (int j = 0; j < column; j++) {  // 商品信息
                Paragraph paragraph = new Paragraph(String.valueOf(list.get(j)), bodyChinese);
                PdfPCell cell = new PdfPCell(paragraph);
                cell.setVerticalAlignment(Element.ALIGN_CENTER);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setLeading(0, (float) 1.4);
//                cell.setFixedHeight(16);
                table.addCell(cell);
            }
        }
        table.setSplitLate(false);
        PdfUtil.tableHeight = (int) table.getTotalHeight();
//        System.out.println("T1表格高度: " + PdfUtil.tableHeight);
        return table;
    }

    private static Element addBiaoTi(Font fontChinese, Font bodyChinese, String s1, String s2) throws DocumentException {
        int ch = 20;
        PdfPTable table = new PdfPTable(3);
        table.setHorizontalAlignment(Element.ALIGN_CENTER);
        //// 设置表格宽度比例为%100
        table.setWidthPercentage(100);
        // 设置表格的宽度
        table.setTotalWidth(520);
        // 也可以每列分别设置宽度
        table.setTotalWidth(new float[]{220, 80, 220});
        // 锁住宽度
        table.setLockedWidth(true);
        // 设置表格上面空白宽度
        table.setSpacingBefore(15f);
        // 设置表格下面空白宽度
        table.setSpacingAfter(10f);
        // 设置表格默认为无边框
        table.getDefaultCell().setBorder(0);
        Paragraph p1 = new Paragraph("", bodyChinese);
        PdfPCell c1 = new PdfPCell(p1);
        c1.setBorder(Rectangle.NO_BORDER);
        c1.setFixedHeight(ch);
        table.addCell(c1);
        Paragraph p2 = new Paragraph(s1, fontChinese);
        PdfPCell c2 = new PdfPCell(p2);
        c2.setBorder(Rectangle.NO_BORDER);
        c2.setFixedHeight(ch);
        table.addCell(c2);
        Paragraph p3 = new Paragraph(s2, bodyChinese);
        PdfPCell c3 = new PdfPCell(p3);
        c3.setVerticalAlignment(PdfPCell.ALIGN_BOTTOM);
        c3.setHorizontalAlignment(Element.ALIGN_RIGHT);
        c3.setBorder(Rectangle.NO_BORDER);
        c3.setFixedHeight(ch);
        table.addCell(c3);


        return table;
    }

    private static Element addYeTou(Font bodyChinese, String s1, String s2, String s3, String s4, String s6) throws DocumentException {
        int ch = 20;
        PdfPTable table = new PdfPTable(2);
        //// 设置表格宽度比例为%100
        table.setWidthPercentage(100);
        // 设置表格的宽度
        table.setTotalWidth(520);
        // 也可以每列分别设置宽度
        table.setTotalWidth(new float[]{340, 180});
        // 锁住宽度
        table.setLockedWidth(true);
        // 设置表格上面空白宽度
        table.setSpacingBefore(15f);
        // 设置表格下面空白宽度
        table.setSpacingAfter(10f);
        // 设置表格默认为无边框
        table.getDefaultCell().setBorder(0);
        Paragraph p1 = new Paragraph(s1, bodyChinese);
        PdfPCell c1 = new PdfPCell(p1);
        c1.setBorder(Rectangle.NO_BORDER);
        c1.setFixedHeight(ch);
        table.addCell(c1);
        Paragraph p2 = new Paragraph(s4, bodyChinese);
        PdfPCell c2 = new PdfPCell(p2);
        c2.setBorder(Rectangle.NO_BORDER);
        c2.setFixedHeight(ch);
        table.addCell(c2);
        Paragraph p3 = new Paragraph(s3, bodyChinese);
        PdfPCell c3 = new PdfPCell(p3);
        c3.setBorder(Rectangle.NO_BORDER);
        c3.setFixedHeight(ch);
        table.addCell(c3);
        Paragraph p4 = new Paragraph(s6, bodyChinese);
        PdfPCell c4 = new PdfPCell(p4);
        c4.setBorder(Rectangle.NO_BORDER);
        c4.setFixedHeight(ch);
        table.addCell(c4);


        return table;
    }

    private static Element addString(Font bodyChinese, String str) {
        Paragraph paragraph = new Paragraph(str, bodyChinese);
        return paragraph;

    }

    private static String buqichangdu(String tmpStr, int Lth) throws UnsupportedEncodingException {
        if (tmpStr.getBytes("GBK").length > Lth) {
            byte[] nameBytes = tmpStr.getBytes("GBK");
            byte[] tmp = new byte[Lth];
            for (int i = 0; i < Lth; i++) {
                tmp[i] = nameBytes[i];
            }
            tmpStr = new String(tmp, "GBK");
        } else {
            while (tmpStr.getBytes("GBK").length < Lth) {
                tmpStr += " ";
            }
        }

        return tmpStr;

    }

    private static Element addFirst(Font bodyChinese, String orderNo) throws UnsupportedEncodingException {
        Paragraph paragraph = new Paragraph(30);
        Chunk chunk = new Chunk(buqichangdu("供方(甲方): 山东临钢电子商务股份有限公司", 70), bodyChinese);
        Chunk chunk1 = new Chunk("合同编号: " + orderNo, bodyChinese);
        paragraph.add(chunk);
        paragraph.add(chunk1);
        return paragraph;
    }


    private static Element addTwo(Font bodyChinese, String name, String address) throws UnsupportedEncodingException {

        Paragraph paragraph = new Paragraph();
        Chunk chunk = new Chunk(buqichangdu("需方(乙方): " + name, 70), bodyChinese);
//        if(name.getBytes("GBK").length > 60) {
//            byte[] nameBytes = name.getBytes("GBK");
//            byte[] tmp = new byte[60];
//            for(int i = 0; i < 60; i ++) {
//                tmp[i] = nameBytes[i];
//            }
//            name = new String(tmp, "GBK");
//        } else {
//            while(name.getBytes("GBK").length < 60) {
//                name += " ";
//            }
//        }
//        Chunk temp = new Chunk(name, bodyChinese);
        Chunk chunk1 = new Chunk("签约地点: " + address, bodyChinese);
        paragraph.add(chunk);
//        paragraph.add(temp);
        paragraph.add(chunk1);
        return paragraph;
    }

    private static Element addThree(Font bodyChinese, String datetime) throws UnsupportedEncodingException {
        Paragraph paragraph = new Paragraph();
        Chunk chunk = new Chunk(buqichangdu("   ", 70), bodyChinese);
        Chunk chunk1 = new Chunk("签约时间: " + datetime, bodyChinese);
        paragraph.add(chunk);
        paragraph.add(chunk1);
        return paragraph;
    }

}