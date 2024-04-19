package handlers.recruit;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import corp.corp.Corp;
import corp.corp.CorpService;
import handlers.Handler;
import recruit.recruitdetail.RecruitDetail;
import recruit.recruitdetail.RecruitDetailService;
import recruit.recruitlist.RecruitList;
import recruit.recruitlist.RecruitListService;

public class ApiListHandler implements Handler {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String authKey = "WNKXZRZNR5AUCD0GJSCZJ2VR1HK";
		int startPage = 6;
		int display = 5;
		String urlList = "http://openapi.work.go.kr/opi/opi/opia/wantedApi.do?authKey=" + authKey
				+ "&callTp=L&returnType=XML&empTpGb=1&startPage=" + startPage + "&display=" + display;

		//
		ArrayList<Corp> clist = new ArrayList<Corp>();
		ArrayList<RecruitList> rllist = new ArrayList<RecruitList>();
		ArrayList<RecruitDetail> rdlist = new ArrayList<RecruitDetail>();
		try {
			URL url1 = new URL(urlList);
			URLConnection conn1 = url1.openConnection();

			InputStream is1 = conn1.getInputStream();

			DocumentBuilderFactory factory = DocumentBuilderFactory.newDefaultInstance();

			DocumentBuilder builder = factory.newDocumentBuilder();

			Document doc1 = builder.parse(is1);

			Element root1 = doc1.getDocumentElement();
			NodeList wantedNodes = root1.getElementsByTagName("wanted");
			int reqCnt = 0;
			int saveCntMemCorp = 0;
			int saveCntRecruit = 0;
			for (int i = 0; i < wantedNodes.getLength(); i++) {
				Element wanted = (Element) wantedNodes.item(i);
				String wantedAuthNo = wanted.getElementsByTagName("wantedAuthNo").item(0).getTextContent();
				String busino = wanted.getElementsByTagName("busino").item(0).getTextContent();
				String sal = wanted.getElementsByTagName("sal").item(0).getTextContent();
				String minSal = wanted.getElementsByTagName("minSal").item(0).getTextContent();
				String maxSal = wanted.getElementsByTagName("maxSal").item(0).getTextContent();
				String regDt = wanted.getElementsByTagName("regDt").item(0).getTextContent();
				String closeDt = wanted.getElementsByTagName("closeDt").item(0).getTextContent();
				String zipCd = wanted.getElementsByTagName("zipCd").item(0).getTextContent();
				String strtnmCd = wanted.getElementsByTagName("strtnmCd").item(0).getTextContent();
				String basicAddr = wanted.getElementsByTagName("basicAddr").item(0).getTextContent();
				String detailAddr = wanted.getElementsByTagName("detailAddr").item(0).getTextContent();
				String smodifyDtm = wanted.getElementsByTagName("smodifyDtm").item(0).getTextContent();

				//
				String urlDetail = "https://openapi.work.go.kr/opi/opi/opia/wantedApi.do?authKey=" + authKey
						+ "&callTp=D&returnType=XML&wantedAuthNo=" + wantedAuthNo + "&infoSvc=VALIDATION";

				URL url2 = new URL(urlDetail);
				URLConnection conn2 = url2.openConnection();

				InputStream is2 = conn2.getInputStream();

				Document doc2 = builder.parse(is2);

				Element root2 = doc2.getDocumentElement();

				NodeList corpInfoNode = root2.getElementsByTagName("corpInfo");
				NodeList wantedInfoNode = root2.getElementsByTagName("wantedInfo");
				NodeList empchargeInfoNode = root2.getElementsByTagName("empchargeInfo");
				Element corpInfo = (Element) corpInfoNode.item(0);
				Element wantedInfo = (Element) wantedInfoNode.item(0);
				Element empchargeInfo = (Element) empchargeInfoNode.item(0);

				//
				String corpNm = corpInfo.getElementsByTagName("corpNm").item(0).getTextContent();
				String corpAddr = corpInfo.getElementsByTagName("corpAddr").item(0).getTextContent();
				String homePg = corpInfo.getElementsByTagName("homePg").item(0).getTextContent();

				//
				String jobsNm = wantedInfo.getElementsByTagName("jobsNm").item(0).getTextContent();
				String wantedTitle = wantedInfo.getElementsByTagName("wantedTitle").item(0).getTextContent();
				String relJobsNm = wantedInfo.getElementsByTagName("relJobsNm").item(0).getTextContent();
				String jobCont = wantedInfo.getElementsByTagName("jobCont").item(0).getTextContent();
				String workRegion = wantedInfo.getElementsByTagName("workRegion").item(0).getTextContent();
				String workdayWorkhrCont = wantedInfo.getElementsByTagName("workdayWorkhrCont").item(0)
						.getTextContent();

				// srchKeywordNm(xml에서 키워드 태그를 ArrayList로 받고 db저장은 String으로)
				NodeList srchKeywordNmNodes = root2.getElementsByTagName("keywordList");
				ArrayList<String> srchKeywordNmList = new ArrayList<String>();
				for (int j = 0; j < srchKeywordNmNodes.getLength(); j++) {
					String srchKeywordNm = wantedInfo.getElementsByTagName("srchKeywordNm").item(0).getTextContent();
					srchKeywordNmList.add(srchKeywordNm);
				}
				String srchKeywordNm = "";
				for (String s : srchKeywordNmList) {
					srchKeywordNm += s + ",";
				}
				srchKeywordNm = srchKeywordNm.replaceAll(",$", "");

				//
				String jobsCd = wantedInfo.getElementsByTagName("jobsCd").item(0).getTextContent();
				String minEdubgIcd = wantedInfo.getElementsByTagName("minEdubgIcd").item(0).getTextContent();
				String regionCd = wantedInfo.getElementsByTagName("regionCd").item(0).getTextContent();
				String enterTpCd = wantedInfo.getElementsByTagName("enterTpCd").item(0).getTextContent();
				String salTpCd = wantedInfo.getElementsByTagName("salTpCd").item(0).getTextContent();

				//
				String contactTelno = empchargeInfo.getElementsByTagName("contactTelno").item(0).getTextContent();

				// 문자열 날짜 처리 및 db 저장을 위한 처리
				SimpleDateFormat bFormat = new SimpleDateFormat("yyMMdd");
				SimpleDateFormat aFormat = new SimpleDateFormat("yyyy-MM-dd");
				SimpleDateFormat bFormat2 = new SimpleDateFormat("yyyyMMddHHmm");
				SimpleDateFormat aFormat2 = new SimpleDateFormat("yyyy-MM-dd");

				java.util.Date tmpRegDt = bFormat.parse(regDt.replaceAll("[^0-9]", ""));
				java.util.Date tmpCloseDt = bFormat.parse(closeDt.replaceAll("[^0-9]", ""));
				java.util.Date tmpSmodifyDtm = bFormat2.parse(smodifyDtm.replaceAll("[^0-9]", ""));

				String transRegDt = aFormat.format(tmpRegDt);
				String transCloseDt = aFormat.format(tmpCloseDt);
				String transSmodifyDtm = aFormat2.format(tmpSmodifyDtm);

				Date regDate = Date.valueOf(transRegDt);
				Date closeDate = Date.valueOf(transCloseDt);
				Date smodifyDatetime = Date.valueOf(transSmodifyDtm);

				//
				CorpService cservice = new CorpService();
				RecruitListService rlservice = new RecruitListService();
				RecruitDetailService rdservice = new RecruitDetailService();

				if (cservice.getByBusiNo(busino) == null) {
//					cservice.addMemberCorp();
					cservice.addCorp(new Corp(0, null, corpNm, corpAddr, busino));
					saveCntMemCorp++;
				}
				if (rlservice.getByWantedAuthNo(busino, wantedAuthNo) == null) {
					rlservice.addRecruitList(new RecruitList(busino, wantedAuthNo, wantedTitle, salTpCd, salTpCd,
							minEdubgIcd, enterTpCd, workRegion, Integer.parseInt(regionCd), jobsNm,
							Integer.parseInt(jobsCd), regDate, closeDate, 0, homePg, false));
					if (rdservice.getByWantedAuthNo(wantedAuthNo) == null) {
						rdservice.addRecruitDetail(new RecruitDetail(0, wantedAuthNo, Integer.parseInt(minSal),
								Integer.parseInt(maxSal), relJobsNm, srchKeywordNm, jobCont, smodifyDatetime, basicAddr,
								detailAddr, contactTelno, 0, 0));
						saveCntRecruit++;
					}
				}
				// 응답을 위한 cnt
				reqCnt++;

				//
				clist.add(new Corp(0, null, corpNm, corpAddr, busino));
				rllist.add(new RecruitList(busino, wantedAuthNo, wantedTitle, salTpCd, sal, minEdubgIcd, enterTpCd,
						workRegion, Integer.parseInt(regionCd), jobsNm, Integer.parseInt(jobsCd), regDate, closeDate, 0,
						homePg, false));
				rdlist.add(new RecruitDetail(0, wantedAuthNo, Integer.parseInt(minSal), Integer.parseInt(maxSal),
						relJobsNm, srchKeywordNm, jobCont, smodifyDatetime, basicAddr, detailAddr, contactTelno, 0, 0));

				request.setAttribute("clist", clist);
				request.setAttribute("rllist", rllist);
				request.setAttribute("rdlist", rdlist);

				//
//				System.out.println(
//						"====================================================================================================");
//				System.out.println(
//						"----------------------------------------------------------------------------------------------------");
//				System.out.println("기업명:" + corpNm);
//				System.out.println("기업주소:" + corpAddr);
//				System.out.println("사업자등록번호:" + busino);
//				System.out.println(
//						"----------------------------------------------------------------------------------------------------");
//
//				System.out.println("공고번호:" + wantedAuthNo);
//				System.out.println("공고명:" + wantedTitle);
//				System.out.println("임금조건코드:" + salTpCd);
//				System.out.println("임금:" + sal);
//				System.out.println("최소학력코드:" + minEdubgIcd);
//				System.out.println("경력코드:" + enterTpCd);
//				System.out.println("근무지역전체주소:" + workRegion);
//				System.out.println("근무지역코드:" + regionCd);
//				System.out.println("직종이름:" + jobsNm);
//				System.out.println("직종코드:" + jobsCd);
//				System.out.println("공고등록일자:" + regDt);
//				System.out.println("공고마감일자:" + closeDt);
//				System.out.println("회사홈페이지:" + homePg);
//				System.out.println(
//						"----------------------------------------------------------------------------------------------------");
//
//				System.out.println("최소임금액:" + minSal);
//				System.out.println("최대임금액:" + maxSal);
//				System.out.println("관련직종:" + relJobsNm);
//				System.out.println("공고키워드:"+srchKeywordNm);
//				System.out.println("공고직무내용:" + jobCont);
//				System.out.println("공고최종수정일:" + smodifyDtm);
//				System.out.println("근무지기본주소:" + basicAddr);
//				System.out.println("근무지상세주소:" + detailAddr);
//				System.out.println("공고담당전화번호:" + contactTelno);
//				System.out.println(
//						"----------------------------------------------------------------------------------------------------");
//
//				System.out.println("근무지우편주소:" + zipCd);
//				System.out.println("근무지도로명주소:" + strtnmCd);
//				System.out.println("근무시간/형태:" + workdayWorkhrCont);
//				System.out.println(
//						"----------------------------------------------------------------------------------------------------");
//
//				System.out.println("공고등록일자-날짜변환:" + regDate);
//				System.out.println("공고마감일자-날짜변환:" + closeDate);
//				System.out.println("공고최종수정일자-날짜변환:" + smodifyDatetime);
//				System.out.println(
//						"----------------------------------------------------------------------------------------------------");
//				System.out.println(
//						"====================================================================================================");
//				System.out.println();
				System.out.println();
			}
			System.out.println("응답 줄수:" + reqCnt);
			System.out.println("db저장 mem과corp 줄수:" + saveCntMemCorp);
			System.out.println("db저장 recruit 줄수:" + saveCntRecruit);

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "/recruit/apilist.jsp";
	}

}
