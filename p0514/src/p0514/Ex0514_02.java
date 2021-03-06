package p0514;

import java.util.Scanner;

public class Ex0514_02 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		String [] name = new String [10];
		int [][] score = new int [10][4];
		double [] avg = new double [10];
		String [] subject = {"국어","영어","수학"};
        int count=0;//학생성적을 몇명입력했는지 확인하는 변수
        String check ="";//0 또는 학생이름 확인변수 
        int searchNum = 0;//학생성적수정에 사용하는 변수
        
        
        
		Loop1:while(true) {
			System.out.println("-----------------------------------");
			System.out.println("[ 학생성적처리 프로그램 ]");
			System.out.println("-----------------------------------");
			System.out.println("1,학생성적추가");
			System.out.println("2,학생성적수정");
			System.out.println("3,학생성적출력");
			System.out.println("4,학생성적검색");
			System.out.println("0,프로그램종료");
			System.out.println("-----------------------------------");
			System.out.println("원하는 번호를 입력하세여>>");
			int choice = scan. nextInt();
			
			switch(choice){
			case 1://1,학생성적추가
				System.out.println("[학생성적추가 메뉴]");
				//프로그램 추가
				//3명의 학생이름, 국어, 영어, 수학 점수를 입력받아,합계, 평균까지 출력 
				//이름-String, 국어,영어,수학,합계-int, 평균-double
				
				//입력
				for (int i=count; i<score.length; i++) {
					System.out.println("학생 이름을 입력하세요.(상위메뉴이동:0)>>");
					check = scan.next();
					//0이 입력되었는지 확인
					if(check.equals("0")){
						System.out.println("상위메뉴로 이동합니다.");
						break;
					}

					name[i] = check;//이름저장
					
					for (int j=0; j<(score[i].length-1); j++) {
						System.out.println(subject[j]+"점수를 입력하세요");
						score[i][j] = scan.nextInt();
					}
					score[i][3] = score[i][0]+score[i][1]+score[i][2];//합계
					avg[i] = score[i][3]/3.0; //평균
					count++; //학생1명추가
					
					System.out.println((i+1)+"명의 학생 정보를 입력되었습니다.");
				}
				break;				
				
			case 2:
				System.out.println("[학생성적수정 메뉴]");
				//수정하려면 누구 수정할지?
				//수정할 학생을 찾아야람.
				System.out.println("수정할 학생이름을 입력하세여(0.상위메뉴이동)");
				check = scan.next(); //수정할 학생 이름검색
				//입력하 내용이
				if(check.equals("0")) {
					System.out.println("상위메뉴로 이동합니다.!");
					break;
				}
				searchNum = -1; //해당학생이 있는지 없는지 확인
                //해당학생검색
				for(int i=0; i<count; i++) {
					if(check.equals(name[i])) {
					     searchNum = i;
					}
				}
				
				//해당학생이 없을시
				if(searchNum == -1) {
					System.out.println("해당학생이 없습니다.!");
					break;
					
				}
				//해당학생이 있을시
				System.out.println(check+"해당학생을 찾았습니다");
				//무슨 과목을 수정할지
				System.out.println("수정할 과목을 선택하세요>>>");
				System.out.println("1.국어 2.영어 3.수학");
				System.out.println("수정할 과목 번호를 입력하세요.>>");
				int sNum = scan.nextInt();
				//0.국어 -> subject[0] =국어
				//국어 현재점수: score[0][0]  -> 국어 현재점수 : 100 ->90
				System.out.println(subject[sNum-1]+"현재점수 : "+score[searchNum][sNum-0]);
				System.out.println(subject[1]+"현재점수 : "+score[0][0]);
				System.out.println("수정할 점수 입역 : ");
				score[searchNum][sNum] = scan.nextInt();
				
				//합계수정
				score[searchNum][3] = score[searchNum][0]+score[searchNum][1]+score[searchNum][2];
				avg[searchNum] = score[searchNum][3]/3.0; //평균
				System.out.println("수정이 완료되었습니다.!");
	
				//프로그램 수정
				break;
				
				
			case 3:
				System.out.println("[학생성적출력 메뉴]");
				System.out.println("이름\t국어\t영어\t수학\t총점\t평균점\n");
				System.out.println("---------------------------------");
				
				for(int i=0; i<count; i++) {
					System.out.print(name[i]+"\t");//이름 출력
					for (int j=0; j<score[i].length; j++) {
						System.out.print(score[i][j]+"\t");//국어,영어,수학,합계
					}
					System.out.printf("%.2f \n", avg[i]);//평균
					System.out.println();
				}
				//프로그램 수정
				break;
				
			case 4:
				System.out.println("----->학생성적검색 메뉴입니다.!");
				//프로그램 수정
				break;
		
			case 0:
				System.out.println("프로그램을 종료합니다.!");
				//프로그램 수정
				break Loop1;
		
			default:
				System.out.println("번호를 잘못 입력했습니다.!");
				break;
			}//switch
		
		
		
		}//while

	}

}
