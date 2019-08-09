import java.util.*;

/*
 * Smith Changeling PC Assistant by GM Sarah Lepidopterane.
 * because you can only do t!dice so many times before thinking 
 * "I could code something to do this for me..."
 */

// TODO(lepidopterane): DEBUG virtue ≠ vice, impatient and patient don't work together

// TODO(lepidopterane): merit + contract dabble if that's wanted

// TODO(lepidopterane): updating as needed, use this to pre-roll characters AT HOME

// TODO(lepidopterane): toggle seeming-kith dependence

public class Changeling {
  public static String[] beastKiths = {"Bendybones","Broadback","Chimera", "Cleareyes","Coldscale",
		  "Coyote","Hunterheart","Nix","Riddleseeker","Roteater","Runnerswift","Skitterskulk",
		  "Steepscrambler","Swimmerskin","Truefriend","Venombite","Windwing"};
  
  public static String[] darklingKiths = {"Antiquarian","Gravewight","Illes", "Leechfinger",
		  "Lurker","Lurkglider","Mirrorskin","Nightsinger","Palewraith","Pishacha","Razorhand",
		  "Skogsra","Tunnelgrub","Whisperwisp"};
  
  public static String[] elementalKiths = {"Airtouched","Apsaras","Automaton", "Leechfinger",
		  "Lurker","Lurkglider","Mirrorskin","Nightsinger","Palewraith","Pishacha","Razorhand",
		  "Skogsra","Tunnelgrub","Whisperwisp"};
  
  public static String[] virtues = {"Merciful", "Loyalty", "Ambitious","Charitable","Courageous",
		  "Generous","Honest","Hopeful","Humble","Just","Loving","Patient","Peaceful",
		  "Righteous","Responsible","Trustworthy"};
  
  public static String[] vices = {"Ambitious", "Arrogant", "Corrupt","Cowardly","Cruel",
		  "Deceitful","Greedy","Hateful","Impatient","Pessimistic","Treacherous","Untrustworthy",
		  "Violent","Irresponsible"};
  
  public static String[] mentalSkillStrings = {"Academics", "Arts", "Computers", "Crafts",
		  "Investigation", "Medicine","Occult", "Science"};
  public static String[] physicalSkillStrings = {"Athletics", "Brawl", "Stealth", "Drive","Firearms",
		  "Larceny","Survival", "Weaponry"};
  public static String[] socialSkillStrings = {"Empathy", "Expression", "Persuasion", "Intimidation",
		  "Socialize", "Streetwise","Subterfuge", "Animal Ken"};
	
  public static void main (String[] args){
	  int[] statResults = {0,0,0};
	  int[] skillResults={0,0,0};
	  
	  String seeming = "Darkling";
	  String kith = "";
	  String virtue = "";
	  String vice = "";
	  String mentalSpecialty = "";
	  String physicalSpecialty1 = ""; // ath, brawl or stealth!
	  String physicalSpecialty2 = "";
	  String socialSpecialty = "";
	  
	  int[] mentalAttributes = {1,1,1};
	  int[] physicalAttributes = {1,1,1};
	  int[] socialAttributes = {1,1,1};
	  
	  int[] mentalSkills = {0,0,0,0,0,0,0,0};
	  int[] physicalSkills = {0,0,0,0,0,0,0,0};
	  int[] socialSkills = {0,0,0,0,0,0,0,0};
	  
	  int health = 0;
	  int willpower = 0;
	  int perception = 0;
	  int defense = 0;
	  int initiative = 0;
	  int memory = 0;
	  int speed = 0;
	  
	  int k = (int) (Math.random()*darklingKiths.length);  
	  kith=darklingKiths[k];
	  
	  System.out.println(seeming+" | "+kith);
	  
	  k = (int) (Math.random()*virtues.length);  
	  virtue=virtues[k];
	  
	  k = (int) (Math.random()*vices.length);  
	  vice=vices[k];
	  
	  System.out.println(virtue+" | "+vice);
	  
	  int primary = -1;
	  int minor = -1;
	  
	  while(primary == minor){
		  primary = (int) (Math.random()*mentalAttributes.length);
		  minor = (int) (Math.random()*mentalAttributes.length);
	  }
	  
	  for(int area = 0; area < 3; area++){
		  if (area == primary){
			  statResults[area] = 5;
			  skillResults[area] = 11;
		  } else if (area == minor){
			  statResults[area] = 3;
			  skillResults[area] = 4;
		  } else { 
			  statResults[area] = 4;
			  skillResults[area] = 7;
		}
	  }
	  
	  for (int a = 0; a < statResults[0]; a++){
		  int p = (int) (Math.random()*mentalAttributes.length);
		  mentalAttributes[p]++;
	  }
	  
	  for (int a = 0; a < skillResults[0]; a++){
		  int p = (int) (Math.random()*mentalSkills.length);
		  mentalSkills[p]++;
	  }
	  
	  int msp = 0;
	  int mindex = -1;
	  while(msp==0){
		  int m = (int) (Math.random()*mentalSkills.length);
		  msp = mentalSkills[m];
		  mindex = m;
	  }
	  
	  mentalSpecialty = mentalSkillStrings[mindex];
	  System.out.println("Mental Specialty: "+mentalSpecialty);
	  
	  for (int a = 0; a < statResults[1]; a++){
		  int p = (int) (Math.random()*mentalAttributes.length);
		  physicalAttributes[p]++;
	  }
	  
	  for (int a = 0; a < skillResults[1]; a++){
		  int p;
		  if (a == 0){
			  p = (int) (Math.random()*physicalAttributes.length);
			  physicalSpecialty1 = physicalSkillStrings[p];
			  System.out.println("Physical Specialty 1: "+physicalSpecialty1);
		  } else {
			  p = (int) (Math.random()*physicalSkills.length);
		  }
		  physicalSkills[p]++;
	  }
	  
	  int psp = 0;
	  int pindex = -1;
	  physicalSpecialty2 = ""+physicalSpecialty1;
	  while(psp==0 && physicalSpecialty1.indexOf(physicalSpecialty2)>-1){
		  int p = (int) (Math.random()*physicalSkills.length);
		  psp = physicalSkills[p];
		  physicalSpecialty2 = physicalSkillStrings[p];
		  pindex = p;
	  }
	  
	  physicalSpecialty2 = physicalSkillStrings[pindex];
	  System.out.println("Physical Specialty 2: "+physicalSpecialty2);
	  
	  for (int a = 0; a < statResults[2]; a++){
		  int p = (int) (Math.random()*mentalAttributes.length);
		  socialAttributes[p]++;
	  }
	  
	  for (int a = 0; a < skillResults[2]; a++){
		  int p = (int) (Math.random()*socialSkills.length);
		  socialSkills[p]++;
	  }
	  
	  int ssp = 0;
	  int sindex=-1;
	  while(ssp==0){
		  int s = (int) (Math.random()*socialSkills.length);
		  ssp = socialSkills[s];
		  sindex = s;
	  }
	  
	  socialSpecialty = socialSkillStrings[sindex];
	  System.out.println("Social Specialty: "+socialSpecialty);
	  
	  System.out.println(""+mentalAttributes[0]+" "+mentalAttributes[1]+" "+mentalAttributes[2]);
	  System.out.println(""+physicalAttributes[0]+" "+physicalAttributes[1]+" "+physicalAttributes[2]);
	  System.out.println(""+socialAttributes[0]+" "+socialAttributes[1]+" "+socialAttributes[2]);
	  
	  int ii = 0;
	  for(int i : mentalSkills){
		  System.out.print(mentalSkillStrings[ii]+" "+i+" ");
		  ii++;
	  }
	  
	  System.out.println(" ");
	  ii = 0;
	  for(int i : physicalSkills){
		  System.out.print(physicalSkillStrings[ii]+" "+i+" ");
		  ii++;
	  }
	  
	  System.out.println(" ");
	  ii = 0;
	  for(int i : socialSkills){
		  System.out.print(socialSkillStrings[ii]+" "+i+" ");
		  ii++;
	  }
	  
	  health = 5+physicalAttributes[2];
	  willpower = mentalAttributes[2]+socialAttributes[2];
	  perception = mentalAttributes[1]+socialAttributes[2];
	  initiative = physicalAttributes[1]+socialAttributes[2];
	  memory = mentalAttributes[0]+socialAttributes[2];
	  speed = 5+physicalAttributes[0]+physicalAttributes[1];
	  
	  if (mentalAttributes[1]<physicalAttributes[1]){
		  defense = mentalAttributes[1];
	  } else {
		  defense = physicalAttributes[1];
	  }
	  
	  System.out.println("\n\nHealth: "+health+" Willpower: "+willpower+" Perception: "+perception);
	  System.out.println("Initiative: "+initiative+" Memory: "+memory+" Speed: "+speed);
	  System.out.println("Defense: "+defense);
	  
		}
	
}
