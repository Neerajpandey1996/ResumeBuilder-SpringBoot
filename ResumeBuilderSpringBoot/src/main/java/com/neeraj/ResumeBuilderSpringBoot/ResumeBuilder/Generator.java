package com.neeraj.ResumeBuilderSpringBoot.ResumeBuilder;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.itextpdf.io.font.FontConstants;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.kernel.pdf.canvas.draw.SolidLine;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.*;
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.border.SolidBorder;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.LineSeparator;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.TabStop;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TabAlignment;
import com.itextpdf.layout.property.TextAlignment;
import com.neeraj.ResumeBuilderSpringBoot.model.AddressDetail;
import com.neeraj.ResumeBuilderSpringBoot.model.EducationDetail;
import com.neeraj.ResumeBuilderSpringBoot.model.OtherDetail;
import com.neeraj.ResumeBuilderSpringBoot.model.ProjectDetail;
import com.neeraj.ResumeBuilderSpringBoot.model.ResumeDetail;
import com.neeraj.ResumeBuilderSpringBoot.model.SkillDetail;
import com.neeraj.ResumeBuilderSpringBoot.model.WorkExprDetail;
import com.neeraj.ResumeBuilderSpringBoot.service.ResumeDetailDAO;
import com.itextpdf.text.Element;
public class Generator 
{
	public void resumeGenerator(ResumeDetail resumeDetail ,List<EducationDetail> educationDetail,
			List<WorkExprDetail> workExprDetail,List<SkillDetail> skillDetail ,
			List<ProjectDetail> projectDetail,List<OtherDetail> otherDetail) throws IOException
	{
		
		String nameforFile=resumeDetail.getName();
		int idforFile=resumeDetail.getId();
          String fileName=nameforFile+idforFile;
          
       String dest="N:\\Core Java\\"+fileName+".pdf";
		
		PdfWriter writer=new PdfWriter(dest);
		
		PdfDocument doc =new PdfDocument(writer);
		
		Document document=new Document(doc);
		
//---------------------------------------------------Header Part ---------------------------------------------------------		
		
		BasicDetailsGenerator basicDetail=new BasicDetailsGenerator();
		List<String> header=basicDetail.headerDetail(resumeDetail);
	
		String[] strheader=new String[6];
				
		for(int i=0;i<header.size();i++)
		{
			strheader[i]=header.get(i);
		}
		
		Paragraph para[]=new Paragraph[strheader.length];
		
		int sizeForHeader=strheader.length-1; //becase declaration will be at end
		for(int i=0;i<sizeForHeader;i++)
		{
			if(strheader[i]!=null)
			{
			
				if(i==0)
			    {
				para[i]=new Paragraph(strheader[i]);
				para[i].setFontSize(22f);
				para[i].setFont(PdfFontFactory.createFont(FontConstants.TIMES_ROMAN));
				para[i].setBold();
				document.add(para[i]);
			    }
			
				else
			    {
		     	para[i]=new Paragraph(strheader[i]);
			    para[i].setFontSize(17f);
			    para[i].setFont(PdfFontFactory.createFont(FontConstants.TIMES_ROMAN));
		        document.add(para[i]);
			    }
			
			}
		}
		
		
//------------------------------------------ Header Complete-----------------------------------------------------------------
		
		
//------------------------------------------Education Detail-------------------------------------------------------------------
		
		
		int size=educationDetail.size();
		if(!educationDetail.isEmpty())
		{
		
		String[] courceName=new String[size];
		String[] schoolName=new String[size];
		String[] yearOfPassing=new String[size];
		String[] percentage=new String[size];
		
		for(int i=0;i<size;i++)
		{
			courceName[i]=educationDetail.get(i).getCourseName();
			schoolName[i]=educationDetail.get(i).getSchoolName();
			yearOfPassing[i]=educationDetail.get(i).getYearOfPassing();
			percentage[i]=educationDetail.get(i).getPercentage();
		}
		
		int sizeOfCell=courceName.length+schoolName.length+yearOfPassing.length+percentage.length;
		float[] coldim= {150f,150f,150f,150f};
		Table table=new Table(coldim);
		
		Cell c1=new Cell();
		c1.add("Course Name");
		c1.setBackgroundColor(Color.LIGHT_GRAY);
		table.addCell(c1);
		
		Cell c2=new Cell();
		c2.add("School Name");
		c2.setBackgroundColor(Color.LIGHT_GRAY);
		table.addCell(c2);
		
		Cell c3=new Cell();
		c3.add("Year of Passing");
		c3.setBackgroundColor(Color.LIGHT_GRAY);
		table.addCell(c3);
		
		Cell c4=new Cell();
		c4.add("Percentage");
		c4.setBackgroundColor(Color.LIGHT_GRAY);
		table.addCell(c4);
		
		System.out.println(sizeOfCell);
		
		Cell cell[]=new Cell[sizeOfCell];
		int j=0;
		for(int i=0;i<size;i++)
		{
			cell[j]=new Cell();
			cell[j].add(courceName[i]);
			j++;
			cell[j]=new Cell();
			cell[j].add(schoolName[i]);
			j++;
			cell[j]=new Cell();
			cell[j].add(yearOfPassing[i]);
			j++;
			cell[j]=new Cell();
			cell[j].add(percentage[i]);
			j++;
		}
		
		for(int i=0;i<sizeOfCell;i++)
		{
			table.addCell(cell[i]);
		}
		
		document.add(table);

		Paragraph p=new Paragraph();
		p.add("   ");
		
		document.add(p);
		
		
		}
//-------------------------------------------Education detail complete --------------------------------------------------------		
		
		
//------------------------------------------------------WorkExpr Details-------------------------------------------------------
		
		int sizeforExperience=workExprDetail.size();
		if(!workExprDetail.isEmpty())
		{
			float[] coldim= {600f};
			Table table=new Table(coldim);
			Cell c1=new Cell();
			c1.add("Experience");
			c1.setFontSize(18f);
			c1.setBackgroundColor(Color.LIGHT_GRAY);
			c1.setTextAlignment(TextAlignment.CENTER);
		    table.addCell(c1);
		    document.add(table);
			
			/*
			Paragraph workExprPara=new Paragraph("Experience");
			workExprPara.setFontSize(18f);
			workExprPara.setFont(PdfFontFactory.createFont(FontConstants.TIMES_ROMAN));
			workExprPara.setBold();
			document.add(workExprPara);
			*/
			String[] orgName=new String[sizeforExperience];
			String[] fromYear=new String[sizeforExperience];
			String[] toYear=new String[sizeforExperience];
			String[] role=new String[sizeforExperience];
			String[] description=new String[sizeforExperience];
			
			for(int i=0;i<sizeforExperience;i++)
			{
				orgName[i]=workExprDetail.get(i).getOrgName();
				fromYear[i]=workExprDetail.get(i).getFromYear();
				toYear[i]=workExprDetail.get(i).getToYear();
				role[i]=workExprDetail.get(i).getRole();
				description[i]=workExprDetail.get(i).getDiscription();
			}
			
			int sizeForParagraph=orgName.length+fromYear.length+toYear.length+role.length+description.length;
			
			Paragraph workExprPara1[]=new Paragraph[sizeForParagraph];
			int j=0;
			for(int i=0;i<sizeforExperience;i++)
			{
				workExprPara1[j]=new Paragraph("Company Name : "+orgName[i]+"  ( "+fromYear[i]+" - "+toYear[i]+" )");
				workExprPara1[j].setFontSize(12f);
				workExprPara1[j].setBold();
				document.add(workExprPara1[j]);
				j++;
				
				workExprPara1[j]=new Paragraph("Role : "+role[i]);
				workExprPara1[j].setBold();
				document.add(workExprPara1[j]);
				j++;
				
				workExprPara1[j]=new Paragraph("Description : "+description[i]);
				document.add(workExprPara1[j]);
				j++;
				
				workExprPara1[j]=new Paragraph("---------------------------------------------------------------------------------------------------------------------------");
				document.add(workExprPara1[j]);
				j++;
			}
		}

		
		
		
//------------------------------------------------------WorkExpr Details completed -------------------------------------------------------
	
		
//--------------------------------------------------------------Skill Details---------------------------------
		
		if(!skillDetail.isEmpty())
		{
		int sizeSkillDetail=skillDetail.size();
		
		float[] coldim= {600f};
		Table table=new Table(coldim);
		Cell c1=new Cell();
		c1.add("Skills");
		c1.setFontSize(18f);
		c1.setBackgroundColor(Color.LIGHT_GRAY);
		c1.setTextAlignment(TextAlignment.CENTER);
	    table.addCell(c1);
	    document.add(table);
		/*
		Paragraph skillPara=new Paragraph("Skills");
		skillPara.setFontSize(18f);
		skillPara.setFont(PdfFontFactory.createFont(FontConstants.TIMES_ROMAN));
		skillPara.setBold();
		document.add(skillPara);
		*/
		String[] name=new String[sizeSkillDetail];
		String[] exprInYear=new String[sizeSkillDetail];
		String[] exprInMonth=new String[sizeSkillDetail];
		String[] level=new String[sizeSkillDetail];
		
		
		for(int i=0;i<sizeSkillDetail;i++)
		{
			name[i]=skillDetail.get(i).getName();
			exprInYear[i]=skillDetail.get(i).getExpxInYear();
			exprInMonth[i]=skillDetail.get(i).getExpxInMonth();
			level[i]=skillDetail.get(i).getLevel();
		}
		
	   int lengthForSkill=name.length+exprInYear.length+exprInMonth.length+level.length;
		Paragraph[] paraSkill=new Paragraph[lengthForSkill];
		int i=0;
		for(int j=0;j<sizeSkillDetail;j++)
		{
			paraSkill[i]=new Paragraph(name[j]);
			paraSkill[i].setFontSize(14f);
			paraSkill[i].setFont(PdfFontFactory.createFont(FontConstants.TIMES_ROMAN));
			paraSkill[i].setBold();
			document.add(paraSkill[i]);
			
			i++;
			
			paraSkill[i]=new Paragraph("Good Hands on Experience of :"+exprInYear[j]+" year and "+exprInMonth[j]+" months");
			paraSkill[i].setFontSize(11f);
			paraSkill[i].setFont(PdfFontFactory.createFont(FontConstants.TIMES_ROMAN));
			document.add(paraSkill[i]);
			
			i++;
			
			paraSkill[i]=new Paragraph("Level : "+level[j]);
			paraSkill[i].setFontSize(11f);
			paraSkill[i].setFont(PdfFontFactory.createFont(FontConstants.TIMES_ROMAN));
			document.add(paraSkill[i]);
			
			i++;
		}
		
		}
		
		
//--------------------------------------------------------------Skill Details Completed ------------------------------------
		
		
		
//---------------------------------------------------------Project Details-----------------------------------------
		
		if(!projectDetail.isEmpty())
		{
			
			int sizeOfProject=projectDetail.size();
			float[] coldim= {600f};
			Table table=new Table(coldim);
			Cell c1=new Cell();
			c1.add("Projects");
			c1.setFontSize(18f);
			c1.setBackgroundColor(Color.LIGHT_GRAY);
			c1.setTextAlignment(TextAlignment.CENTER);
		    table.addCell(c1);
		    document.add(table);
			
			/*
			Paragraph projectPara=new Paragraph("Projects");
			projectPara.setFontSize(18f);
			projectPara.setFont(PdfFontFactory.createFont(FontConstants.TIMES_ROMAN));
			projectPara.setBold();
			document.add(projectPara);
			*/
			String[] projectName=new String[sizeOfProject];
			String[] description=new String[sizeOfProject];
			String[] year=new String[sizeOfProject];
			
			for(int i=0;i<sizeOfProject;i++)
			{
				projectName[i]=projectDetail.get(i).getProjectName();
				description[i]=projectDetail.get(i).getProjectDiscription();
				year[i]=projectDetail.get(i).getYear();
			}
			
			int lengthForProject=projectName.length+description.length+year.length;
			
			Paragraph[] paraForProject=new Paragraph[lengthForProject];
			int i=0;
			for(int j=0;j<sizeOfProject;j++)
			{
				paraForProject[i]=new Paragraph(projectName[j]);
				paraForProject[i].setFontSize(14f);
				paraForProject[i].setFont(PdfFontFactory.createFont(FontConstants.TIMES_ROMAN));
				paraForProject[i].setBold();
				document.add(paraForProject[i]);
				
				i++;
				
				paraForProject[i]=new Paragraph(year[j]);
				paraForProject[i].setFontSize(11f);
				paraForProject[i].setFont(PdfFontFactory.createFont(FontConstants.TIMES_ROMAN));
				document.add(paraForProject[i]);
				
				i++;
				
				paraForProject[i]=new Paragraph(description[j]);
				paraForProject[i].setFontSize(12f);
				paraForProject[i].setFont(PdfFontFactory.createFont(FontConstants.TIMES_ROMAN));
				document.add(paraForProject[i]);
			}
					
		}		
					
		
//---------------------------------------------------------Project Details Completed----------------------------------		
	
		
	
//--------------------------------------------------------Other Details-----------------------------------------------		

		if(!otherDetail.isEmpty())
		{
		int sizeforOther=otherDetail.size();
		
		float[] coldim= {600f};
		Table table=new Table(coldim);
		Cell c1=new Cell();
		c1.add("Other Achievements");
		c1.setFontSize(18f);
		c1.setBackgroundColor(Color.LIGHT_GRAY);
		c1.setTextAlignment(TextAlignment.CENTER);
	    table.addCell(c1);
	    document.add(table);
		
	    /*
		Paragraph otherPara=new Paragraph("Other Achievements");
		otherPara.setFontSize(18f);
		otherPara.setFont(PdfFontFactory.createFont(FontConstants.TIMES_ROMAN));
		otherPara.setBold();
		document.add(otherPara);
		*/
		
		String[] name=new String[sizeforOther];
		String[] description=new String[sizeforOther];
		String[] year=new String[sizeforOther];
		
		for(int i=0;i<sizeforOther;i++)
		{
			name[i]=otherDetail.get(i).getName();
			description[i]=otherDetail.get(i).getDiscription();
			year[i]=Integer.toString((int) otherDetail.get(i).getYear());
		}
		
		
		int lengthForProject=name.length+description.length+year.length;
		System.out.println(lengthForProject);
		
		Paragraph[] paraForOther=new Paragraph[lengthForProject];
		
		int j=-1;
		
		for(int i=0;i<sizeforOther;i++)
		{
			j++;
			paraForOther[j] =new Paragraph(name[i]);
			paraForOther[j].setFontSize(15f);
			paraForOther[j].setFont(PdfFontFactory.createFont(FontConstants.TIMES_ROMAN));
			paraForOther[j].setBold();
			document.add(paraForOther[j]);
			
			if(description[i]!=null)
			{
				j++;
				paraForOther[j] =new Paragraph(description[i]);
				paraForOther[j].setFontSize(13f);
				paraForOther[j].setFont(PdfFontFactory.createFont(FontConstants.TIMES_ROMAN));
				document.add(paraForOther[j]);
				
			}
			
			if(year[i]!=null)
			{
				j++;	
				paraForOther[j] =new Paragraph(year[i]);
				paraForOther[j].setFontSize(13f);
				paraForOther[j].setFont(PdfFontFactory.createFont(FontConstants.TIMES_ROMAN));
				document.add(paraForOther[j]);
			}
			
		}
		
		}
		
//--------------------------------------------------------Other Details-----------------------------------------------
	
		
		

		
		
		//Declaration
		
		int len=6;
		if(!header.get(len-1).isEmpty())
		{
			//System.out.println("HEdder is not empty");
		Paragraph para1=new Paragraph("Declaration : "+header.get(len-1));
		para1.setFontSize(14f);
		para1.setFont(PdfFontFactory.createFont(FontConstants.TIMES_ROMAN));
		para1.setBold();
		document.add(para1);
		}
		if(header.get(len-1).isEmpty())
		{
			//System.out.println("HEdder is empty");
			Paragraph para1=new Paragraph("Declaration : All the inforamation is correct and best in my knowledge");
			para1.setFontSize(14f);
			para1.setFont(PdfFontFactory.createFont(FontConstants.TIMES_ROMAN));
			para1.setBold();
			document.add(para1);
			
		}
		
		
		
		
		
		
		document.close();
	}
	
	
	}
	
	
	

