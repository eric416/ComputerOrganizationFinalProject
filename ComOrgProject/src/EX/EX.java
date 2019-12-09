package computer;

class ex
{
   int BA,reg1,reg2,add,regnum1,regnum2,ALUSrc,ALUop,RegDst,funct=0;
   int[] EXMEMbuffer=new int[5];
   
   void set(int BA,int reg1,int reg2,int add,int regnum1,int regnum2,int ALUSrc,int ALUop,int RegDst,int funct) {
	   this.BA=BA;
	   this.reg1=reg1;
	   this.reg2=reg2;
	   this.add=add;
	   this.regnum1=regnum1;
	   this.regnum2=regnum2;
	   this.ALUSrc=ALUSrc;
	   this.ALUop=ALUop;
	   this.RegDst=RegDst;
	   this.funct=funct;
   }
   
   int getALU() {
	   if(ALUop==0) {
		   if(ALUSrc==0)
		   {
			   EXMEMbuffer[2]=reg1+reg2;
			  
		   }
		   else
		   {
			   EXMEMbuffer[2]=reg1+add;
		   }
	   }
	   else if(ALUop==1)
	   {
		   if(ALUSrc==0)
		   {
			   EXMEMbuffer[2]=reg1-reg2;
			  
		   }
		   else
		   {
			   EXMEMbuffer[2]=reg1-add;
		   }
	   }
	   else
	   {
		   if(funct==32)
		   {
			   if(ALUSrc==0)
			   {
				   EXMEMbuffer[2]=reg1+reg2;
				  
			   }
			   else
			   {
				   EXMEMbuffer[2]=reg1+add;
			   }
		   }
		   else
		   {
			   if(ALUSrc==0)
			   {
				   EXMEMbuffer[2]=reg1-reg2;
				  
			   }
			   else
			   {
				   EXMEMbuffer[2]=reg1-add;
			   }
		   }
	   }
	   if(EXMEMbuffer[2]==0)
	   {
		   EXMEMbuffer[1]=1;
	   }
	   else
	   {
		   EXMEMbuffer[1]=0;
	   }
	   return  EXMEMbuffer[2];
   }

   int getBranch()
   {
	   EXMEMbuffer[0]=BA+add*4;
	   return EXMEMbuffer[0];
   }
   
   int getzero()
   {
	  
	   return EXMEMbuffer[1];
   }
   
   int getreg2()
   {
	   EXMEMbuffer[3]=reg2;
	   return EXMEMbuffer[3];
   }
   
   int getregnum()
   {
	   if(RegDst==0)
	   {
		   EXMEMbuffer[4]=regnum1;
	   }
	   else
	   {
		   EXMEMbuffer[4]=regnum2;
	   }
	   
	   return EXMEMbuffer[4];
   }
}

public class EX
{
	public static void main(String[] argv)
	{
		ex ex1=new ex();
	}
}