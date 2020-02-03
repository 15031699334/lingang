package com.boot.gang.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

import javax.servlet.ServletOutputStream;

public class PdfUtil {
    public static void exportPdf(Map<String, Object> map, String gongzhangPath, ServletOutputStream outputStream) {
        //参数区
        String name = map.get("name") == null ? "供方甲方山东临钢电子商务股份有限公司" : map.get("name").toString();
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
        if(list == null) {
            list = createTestList();
        }
        Map<String, String> secondInfoMap = (Map<String, String>) map.get("secondInfo");
        if(secondInfoMap == null) {
            secondInfoMap = new HashMap<>();
            secondInfoMap.put("name", "乐映文化");
            secondInfoMap.put("address", "乐映文化");
            secondInfoMap.put("phone", "乐映文化");
            secondInfoMap.put("fax", "乐映文化");
            secondInfoMap.put("openBank", "乐映文化");
            secondInfoMap.put("bankCode", "乐映文化");
            secondInfoMap.put("signature", "乐映文化");
        }

        Document document = new Document(PageSize.A4);
        try {
            PdfWriter writer = PdfWriter.getInstance(document, outputStream);
            document.open();
            BaseFont bf = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H",BaseFont.NOT_EMBEDDED);
            Font fontChinese = new Font(bf, 20, Font.NORMAL);
            Font bodyChinese = new Font(bf, 9, Font.NORMAL);
            Paragraph paragraph = new Paragraph("供需合同", fontChinese);
            paragraph.setAlignment(1);
            document.add(paragraph);
            document.add(addFirst(bodyChinese));
            document.add(addTwo(bodyChinese, name, address));
            document.add(addThree(bodyChinese, createTime));
            document.add(addString(bodyChinese, "为确保买卖双方双方的共同利益实现互利双赢的目的，根据《中华人民共和国合同法》之规定，经供需双方充分协商" +
                    "特订立此合同以便共同遵守。"));
            document.add(addString(bodyChinese, "一、 货物明细"));
            document.add(addTable(bodyChinese, list));
            document.add(addString(bodyChinese, "二、质量标准：按产品对应钢厂的现行牌号产品对应的标准执行。"));
            //提货方式
            paragraph = new Paragraph();
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

            document.add(addString(bodyChinese,"五、验收标准及异议处理："));
            document.add(addString(bodyChinese,"1、重量验收标准：按供方出库单记录为结算重量。"));
            document.add(addString(bodyChinese,"2、数量异议处理：双方约定，过磅抄码计重，磅差执行国标±3‰ ,若超出±3‰原产品封存复磅。"));
            document.add(addString(bodyChinese,"3、质量异议处理：需方于收货后7日内以书面形式向供方提出异议，并将原产品封存，供方根据钢厂质量保证书及钢厂代表现场勘查情况处理相关质量问题，逾期供方不承担任何责任。"));
            document.add(addString(bodyChinese,"六、付款方式及期限："));
            document.add(addString(bodyChinese,"1、需方按照平台规则在平台拍到产品后，需在两小时内把全额货款汇到供方指定账户（以供方进账时间为准），款到账后合同生效，提货后由供方向需方开具全额增值税发票。"));
            document.add(addString(bodyChinese,"2、供需双方约定以人民币为结算货币，可通过电汇、现金、银行承兑汇票等结算方式进行付款。实际结算金额按需方实提进行货款多退少补；"));
            document.add(addString(bodyChinese,"3、如果需方未按合同约定付清款项，供方有权处理所有货物，此客户不再享有锁货权利。"));
            //剪切尺寸及方式
            paragraph = new Paragraph();
            paragraph.add(new Chunk("七、剪切尺寸及方式：", bodyChinese));
            paragraph.add(undefinedString(bodyChinese, cutType));
            document.add(paragraph);
            document.add(addString(bodyChinese,"八、合同生效及解除方式：需方按时支付货款后合同生效，本合同一式两份，双方各执壹份，传真件具有同等法律效力，供需双方钱货两清后合同自然解除。"));
            document.add(addString(bodyChinese,"九、争议及解决办法：本台同在执行过程中，如发生争议，应由供需双方友好协商解决。如协商不能解决，可向供方" +
                    "所在地法院提起诉讼，依法追究违约方责任。"));

            document.add(addTailTable(bodyChinese, secondInfoMap));
            document.add(addString(bodyChinese,"注:以上横线处内容手写或涂改无效。"));
            document.add(addImages(gongzhangPath));
            document.close();
            writer.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
        return list;
    }

    private static Element addImages(String imagePath) throws IOException, BadElementException {
        //根据路径读取图片
        Image image = Image.getInstance(imagePath);
        //获取图片页面
        //图片大小自适应
        image.scaleToFit(100, 100);
        //添加图片
        image.setAbsolutePosition(230, 230);
        return image;
    }

    private static Element addTailTable(Font bodyChinese, Map<String, String> secondInfoMap) throws DocumentException {
        // 表格类
        int column = 2;
        int row = 7;
        PdfPTable table =  new PdfPTable(column);
        table.setSpacingBefore(10f);
        // 设置表格下面空白宽度
//        table.setSpacingAfter(10f);
        float tatalWidth = 500;
        int size = 2;
        float width[] = new float[size];
        for(int i=0;i<size;i++){
            if(i==0){
                width[i]=240f;
            }else{
                width[i]=240f;
            }
        }
        table.setTotalWidth(width);
        table.setLockedWidth(true);
        table.setKeepTogether(true);
        table.setSplitLate(false);
        table.setSplitRows(true);
        //表格数据填写
        for(int i=0;i < row; i++){
            for(int j=0;j<column;j++){
                Paragraph paragraph = null;
                if(j == 0) {
                    if(i == 0) {
                        paragraph = new Paragraph("供方：泰州慧钢网电子商务有限公司", bodyChinese );
                    } else if(i == 1) {
                        paragraph = new Paragraph("地址：江苏省泰州市每陵区罡杨站前路", bodyChinese );
                    }else if(i == 2) {
                        paragraph = new Paragraph("电话：0523-80767000    80767177", bodyChinese );
                    }else if(i == 3) {
                        paragraph = new Paragraph("传真：0523-80767106    80767096", bodyChinese );
                    }else if(i == 4) {
                        paragraph = new Paragraph("开户行：江苏姜堰农村商业银行股份有限公司罡杨支行", bodyChinese );
                    }else if(i == 5) {
                        paragraph = new Paragraph("账号： 3212840221010088889995", bodyChinese );
                    }else if(i == 6) {
                        paragraph = new Paragraph("委托代理人签字：", bodyChinese );
                    }
                } else {
                    if(i == 0) {
                        paragraph = new Paragraph("需方：" + secondInfoMap.get("name"), bodyChinese );
                    } else if(i == 1) {
                        paragraph = new Paragraph("地址：" + secondInfoMap.get("address"), bodyChinese );
                    }else if(i == 2) {
                        paragraph = new Paragraph("电话：" + secondInfoMap.get("phone"), bodyChinese );
                    }else if(i == 3) {
                        paragraph = new Paragraph("传真：" + secondInfoMap.get("fax"), bodyChinese );
                    }else if(i == 4) {
                        paragraph = new Paragraph("开户行：" + secondInfoMap.get("openBank"), bodyChinese );
                    }else if(i == 5) {
                        paragraph = new Paragraph("账号： " + secondInfoMap.get("bankCode"), bodyChinese );
                    }else if(i == 6) {
                        paragraph = new Paragraph("委托代理人签字：" + secondInfoMap.get("signature"), bodyChinese );
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
        PdfPTable table =  new PdfPTable(column);
        table.setSpacingBefore(10f);
        // 设置表格下面空白宽度
//        table.setSpacingAfter(10f);
        float tatalWidth = 500;
        int size = tableList.get(0).size();
        float width[] = new float[size];
        for(int i=0;i<size;i++){
            if(i==0){
                width[i]=60f;
            }else{
                width[i]=(tatalWidth-60)/(size-1);
            }
        }
        table.setTotalWidth(width);
        table.setLockedWidth(true);
        table.setKeepTogether(true);
        table.setSplitLate(false);
        table.setSplitRows(true);
        //表格数据填写
        for(int i=0;i<row;i++){
            if(i >= row - 2) {
                Paragraph paragraph = new Paragraph(String.valueOf(tableList.get(i).get(0)), bodyChinese);
                PdfPCell cell = new PdfPCell(paragraph);
                cell.setColspan(8);
                cell.setVerticalAlignment(Element.ALIGN_CENTER);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setLeading(0, (float) 1.4);
//                cell.setFixedHeight(16);
                table.addCell(cell);
                continue;
            }
            List<String> list = tableList.get(i);
            for(int j=0;j<column;j++){
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
        return table;
    }

    private static Element addString(Font bodyChinese, String str) {
        Paragraph paragraph = new Paragraph(str, bodyChinese);;
        return  paragraph;

    }

    private static Element addFirst(Font bodyChinese) {
        Paragraph paragraph = new Paragraph(30);
        Chunk chunk = new Chunk("供方(甲方): 山东临钢电子商务股份有限公司", bodyChinese);
        Chunk temp = new Chunk("                      ");
        Chunk chunk1 = new Chunk("台同编号: 临沂市经济开发区沂蒙云谷B座6层", bodyChinese);
        paragraph.add(chunk);
        paragraph.add(temp);
        paragraph.add(chunk1);
        return paragraph;
    }


    private static Element addTwo(Font bodyChinese, String name, String address) throws UnsupportedEncodingException {
        Paragraph paragraph = new Paragraph();
        Chunk chunk = new Chunk("需方(乙方): ", bodyChinese);
        if(name.getBytes("GBK").length > 44) {
            byte[] nameBytes = name.getBytes("GBK");
            byte[] tmp = new byte[44];
            for(int i = 0; i < 44; i ++) {
                tmp[i] = nameBytes[i];
            }
            name = new String(tmp, "GBK");
        } else {
            while(name.getBytes("GBK").length < 44) {
                name += " ";
            }
        }
        Chunk temp = new Chunk(name, bodyChinese);
        Chunk chunk1 = new Chunk("签约地点: " + address, bodyChinese);
        paragraph.add(chunk);
        paragraph.add(temp);
        paragraph.add(chunk1);
        return paragraph;
    }


    private static Element addThree(Font bodyChinese, String datetime) throws UnsupportedEncodingException {
        Paragraph paragraph = new Paragraph();
        Chunk chunk = new Chunk("                                                        ", bodyChinese);
        Chunk chunk1 = new Chunk("签约时间: " + datetime, bodyChinese);
        paragraph.add(chunk);
        paragraph.add(chunk1);
        return paragraph;
    }
}