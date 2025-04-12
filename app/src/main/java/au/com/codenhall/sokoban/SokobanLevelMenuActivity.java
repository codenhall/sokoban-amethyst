package au.com.codenhall.sokoban;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SokobanLevelMenuActivity extends Activity {

	private static final String MAX_LEVEL_NAME = "max_level";
	private static final String LAST_LEVELSET_NAME = "last_levelset";
	public static final String SHARED_PREFS_NAME = "game_prefs";

	private int lastLevelIndex = -1;

	public static String getMaxLevelPrefName(int levelSetIndex) {
		// historical compat: first level == no suffix
		return MAX_LEVEL_NAME + (levelSetIndex == 0 ? "" : ("_" + levelSetIndex));
	}

	// Key = Level set
	// Value = Button ID
	private static Map<Integer, Integer> levelSetButtonMap = new HashMap<Integer, Integer>();
	static {
		int i=0;
		// Thinking Rabbit
		levelSetButtonMap.put(i++, R.id.levelsOriginalAndExtraButton);
		levelSetButtonMap.put(i++, R.id.levelsBoxxle1Button);
		levelSetButtonMap.put(i++, R.id.levelsBoxxle2Button);
		levelSetButtonMap.put(i++, R.id.levelsPerfectButton);
		levelSetButtonMap.put(i++, R.id.levelsRevengeButton);
		levelSetButtonMap.put(i++, R.id.levelsThinkingRabbitArrangedButton);

		// Aymeric du Peloux
		levelSetButtonMap.put(i++, R.id.levelsMiniCosmosButton);
		levelSetButtonMap.put(i++, R.id.levelsMicroCosmosButton);
		levelSetButtonMap.put(i++, R.id.levelsPicoCosmosButton);
		levelSetButtonMap.put(i++, R.id.levelsNaboCosmosButton);
		levelSetButtonMap.put(i++, R.id.levelsCosmonotesButton);
		levelSetButtonMap.put(i++, R.id.levelsCosmopolyButton);
		levelSetButtonMap.put(i++, R.id.levelsMyriocosmosButton);

		// David Holland
		levelSetButtonMap.put(i++, R.id.levelsTheDH1CollectionButton);
		levelSetButtonMap.put(i++, R.id.levelsTheDH2CollectionButton);
		levelSetButtonMap.put(i++, R.id.levelsTheBagatelleCollectionButton);
		levelSetButtonMap.put(i++, R.id.levelsTheBagatelle2CollectionButton);
		levelSetButtonMap.put(i++, R.id.levelsTheCantripCollectionButton);
		levelSetButtonMap.put(i++, R.id.levelsTheCantrip2CollectionButton);
		levelSetButtonMap.put(i++, R.id.levelsTheMaelstromCollectionButton);
		levelSetButtonMap.put(i++, R.id.levelsDh5Button);

		// David W Skinner
		levelSetButtonMap.put(i++, R.id.levelsMicrobanButton);
		levelSetButtonMap.put(i++, R.id.levelsMicrobanIIButton);
		levelSetButtonMap.put(i++, R.id.levelsMicrobanIIIButton);
		levelSetButtonMap.put(i++, R.id.levelsMicrobanIVButton);
		levelSetButtonMap.put(i++, R.id.levelsSasquatchButton);
		levelSetButtonMap.put(i++, R.id.levelsMasSasquatchButton);
		levelSetButtonMap.put(i++, R.id.levelsSasquatchIIIButton);
		levelSetButtonMap.put(i++, R.id.levelsSasquatchIVButton);
		levelSetButtonMap.put(i++, R.id.levelsSasquatchVButton);
		levelSetButtonMap.put(i++, R.id.levelsSasquatchVIButton);
		levelSetButtonMap.put(i++, R.id.levelsSasquatchVIIButton);
		levelSetButtonMap.put(i++, R.id.levelsSasquatchVIIIButton);
		levelSetButtonMap.put(i++, R.id.levelsSasquatchIXButton);
		levelSetButtonMap.put(i++, R.id.levelsSasquatchXButton);
		levelSetButtonMap.put(i++, R.id.levelsDavidWSkinnerArrangedButton);
		levelSetButtonMap.put(i++, R.id.levelsSasquatchXIButton);
		levelSetButtonMap.put(i++, R.id.levelsSasquatchXIIButton);

		// Yoshio Murase
		levelSetButtonMap.put(i++, R.id.levelsYoshioMurasesHandMadeButton);
		levelSetButtonMap.put(i++, R.id.levelsYoshioMurasesAutoButton);

		// Alberto Garcia
		levelSetButtonMap.put(i++, R.id.levelsAlbertoGarciaButton);
		levelSetButtonMap.put(i++, R.id.levelsAlbertoGarcia2Button);
		levelSetButtonMap.put(i++, R.id.levelsAlbertoGarcia3Button);
		levelSetButtonMap.put(i++, R.id.levelsAlbertoGarcia4Button);
		levelSetButtonMap.put(i++, R.id.levelsAlbertoButton);
		levelSetButtonMap.put(i++, R.id.levelsAlbertoGarciaPlus2Button);
		levelSetButtonMap.put(i++, R.id.levelsAlbertoMultipackButton);
		levelSetButtonMap.put(i++, R.id.levelsBirthdayButton);
		levelSetButtonMap.put(i++, R.id.levelsNewYearButton);
		levelSetButtonMap.put(i++, R.id.levelsPuzzleButton);
		levelSetButtonMap.put(i++, R.id.levelsStrategyButton);
		levelSetButtonMap.put(i++, R.id.levelsZigZagPlusButton);

		// Eric F Tchong
		levelSetButtonMap.put(i++, R.id.levelsAruba1Button);
		levelSetButtonMap.put(i++, R.id.levelsAruba2Button);
		levelSetButtonMap.put(i++, R.id.levelsAruba3Button);
		levelSetButtonMap.put(i++, R.id.levelsAruba4Button);
		levelSetButtonMap.put(i++, R.id.levelsAruba5Button);
		levelSetButtonMap.put(i++, R.id.levelsAruba6Button);
		levelSetButtonMap.put(i++, R.id.levelsAruba7Button);
		levelSetButtonMap.put(i++, R.id.levelsAruba8Button);
		levelSetButtonMap.put(i++, R.id.levelsAruba9Button);
		levelSetButtonMap.put(i++, R.id.levelsAruba10Button);
		levelSetButtonMap.put(i++, R.id.levelsAtlas01Button);
		levelSetButtonMap.put(i++, R.id.levelsCosmacButton);
		levelSetButtonMap.put(i++, R.id.levelsCosmac2Button);
		levelSetButtonMap.put(i++, R.id.levelsCosmac3Button);
		levelSetButtonMap.put(i++, R.id.levelsCosmac4Button);
		levelSetButtonMap.put(i++, R.id.levelsCosmac5Button);
		levelSetButtonMap.put(i++, R.id.levelsCosmac6Button);
		levelSetButtonMap.put(i++, R.id.levelsCosmac7Button);
		levelSetButtonMap.put(i++, R.id.levelsCosmac8Button);
		levelSetButtonMap.put(i++, R.id.levelsCosmac9Button);
		levelSetButtonMap.put(i++, R.id.levelsCosmac10Button);
		levelSetButtonMap.put(i++, R.id.levelsSerena1Button);
		levelSetButtonMap.put(i++, R.id.levelsSerena2Button);
		levelSetButtonMap.put(i++, R.id.levelsSerena3Button);
		levelSetButtonMap.put(i++, R.id.levelsSerena4Button);
		levelSetButtonMap.put(i++, R.id.levelsSerena5Button);
		levelSetButtonMap.put(i++, R.id.levelsSerena6Button);
		levelSetButtonMap.put(i++, R.id.levelsSerena7Button);
		levelSetButtonMap.put(i++, R.id.levelsSerena8Button);
		levelSetButtonMap.put(i++, R.id.levelsSerena9Button);
		levelSetButtonMap.put(i++, R.id.levelsAlakinaButton);
		levelSetButtonMap.put(i++, R.id.levelsAlejandroButton);
		levelSetButtonMap.put(i++, R.id.levelsAtlas02Button);
		levelSetButtonMap.put(i++, R.id.levelsAtlas03Button);
		levelSetButtonMap.put(i++, R.id.levelsAtlas04Button);
		levelSetButtonMap.put(i++, R.id.levelsAtlas05Button);
		levelSetButtonMap.put(i++, R.id.levelsAtlas06Button);
		levelSetButtonMap.put(i++, R.id.levelsAtlas07Button);
		levelSetButtonMap.put(i++, R.id.levelsAtlas08Button);
		levelSetButtonMap.put(i++, R.id.levelsAtlas09Button);
		levelSetButtonMap.put(i++, R.id.levelsAtlas10Button);
		levelSetButtonMap.put(i++, R.id.levelsCadushiButton);
		levelSetButtonMap.put(i++, R.id.levelsChuchubi01Button);
		levelSetButtonMap.put(i++, R.id.levelsChuchubi02Button);
		levelSetButtonMap.put(i++, R.id.levelsChuchubi03Button);
		levelSetButtonMap.put(i++, R.id.levelsChuchubi04Button);
		levelSetButtonMap.put(i++, R.id.levelsChuchubi05Button);
		levelSetButtonMap.put(i++, R.id.levelsChuchubi06Button);
		levelSetButtonMap.put(i++, R.id.levelsChuchubi07Button);
		levelSetButtonMap.put(i++, R.id.levelsChuchubi08Button);
		levelSetButtonMap.put(i++, R.id.levelsChuchubi09Button);
		levelSetButtonMap.put(i++, R.id.levelsChuchubi10Button);
		levelSetButtonMap.put(i++, R.id.levelsChuchubi11Button);
		levelSetButtonMap.put(i++, R.id.levelsChuchubi12Button);
		levelSetButtonMap.put(i++, R.id.levelsChuchubi13Button);
		levelSetButtonMap.put(i++, R.id.levelsChuchubi14Button);
		levelSetButtonMap.put(i++, R.id.levelsChuchubi15Button);
		levelSetButtonMap.put(i++, R.id.levelsDushi01Button);
		levelSetButtonMap.put(i++, R.id.levelsDushi02Button);
		levelSetButtonMap.put(i++, R.id.levelsDushi03Button);
		levelSetButtonMap.put(i++, R.id.levelsDushi04Button);
		levelSetButtonMap.put(i++, R.id.levelsDushi05Button);
		levelSetButtonMap.put(i++, R.id.levelsDushi06Button);
		levelSetButtonMap.put(i++, R.id.levelsDushi07Button);
		levelSetButtonMap.put(i++, R.id.levelsDushi08Button);
		levelSetButtonMap.put(i++, R.id.levelsDushi09Button);
		levelSetButtonMap.put(i++, R.id.levelsDushi10Button);
		levelSetButtonMap.put(i++, R.id.levelsDushi11Button);
		levelSetButtonMap.put(i++, R.id.levelsDushi12Button);
		levelSetButtonMap.put(i++, R.id.levelsDushi13Button);
		levelSetButtonMap.put(i++, R.id.levelsEricFTchongArrangedButton);
		levelSetButtonMap.put(i++, R.id.levelsMangoButton);
		levelSetButtonMap.put(i++, R.id.levelsOriginal51_90RemodeledButton);
		levelSetButtonMap.put(i++, R.id.levelsPassionFruitButton);
		levelSetButtonMap.put(i++, R.id.levelsTammyRockButton);
		levelSetButtonMap.put(i++, R.id.levelsBringamosaButton);
		levelSetButtonMap.put(i++, R.id.levelsCappuccinoButton);
		levelSetButtonMap.put(i++, R.id.levelsLaGolondrina01Button);
		levelSetButtonMap.put(i++, R.id.levelsUnicoButton);

		// Evgeniy Grigoriev
		levelSetButtonMap.put(i++, R.id.levelsGrigr2001Button);
		levelSetButtonMap.put(i++, R.id.levelsGrigr2002Button);
		levelSetButtonMap.put(i++, R.id.levelsGrigrChallengeButton);
		levelSetButtonMap.put(i++, R.id.levelsGrigrCometButton);
		levelSetButtonMap.put(i++, R.id.levelsGrigrSpecialButton);
		levelSetButtonMap.put(i++, R.id.levelsGrigrStarButton);
		levelSetButtonMap.put(i++, R.id.levelsGrigrSunButton);
		levelSetButtonMap.put(i++, R.id.levelsRemodelClubButton);

		// Francois Marques
		levelSetButtonMap.put(i++, R.id.levelsSolobanButton);
		levelSetButtonMap.put(i++, R.id.levels100BoxesButton);
		levelSetButtonMap.put(i++, R.id.levelsNumbersButton);
		levelSetButtonMap.put(i++, R.id.levelsKokobanButton);
		levelSetButtonMap.put(i++, R.id.levelsSokobanOnlineButton);
		levelSetButtonMap.put(i++, R.id.levelsSokolateButton);
		levelSetButtonMap.put(i++, R.id.levelsNovobanButton);
		levelSetButtonMap.put(i++, R.id.levelsSokompactButton);

		// Howard Abed
		levelSetButtonMap.put(i++, R.id.levelsHowardLevels1Button);
		levelSetButtonMap.put(i++, R.id.levelsHowardsSecondSetButton);
		levelSetButtonMap.put(i++, R.id.levelsHowardsThirdSetButton);
		levelSetButtonMap.put(i++, R.id.levelsHowardsFourthSetButton);
		levelSetButtonMap.put(i++, R.id.levelsSokoCreationButton);
		levelSetButtonMap.put(i++, R.id.levelsSokobig70Button);
		levelSetButtonMap.put(i++, R.id.levelsSokobig80Button);

		// Jaques Duthen
		levelSetButtonMap.put(i++, R.id.levelsDimitriAndYorickButton);
		levelSetButtonMap.put(i++, R.id.levelsSokogen990602LevelsButton);

		// Jordi Domenech
		levelSetButtonMap.put(i++, R.id.levelsHaikemonoCollectionButton);
		levelSetButtonMap.put(i++, R.id.levelsHaikemonoCollection2Button);
		levelSetButtonMap.put(i++, R.id.levelsChrysalisVariations01Button);
		levelSetButtonMap.put(i++, R.id.levelsChrysalisVariations02Button);

		// Lee Haywood
		levelSetButtonMap.put(i++, R.id.levelsTheSokHardCollectionButton);
		levelSetButtonMap.put(i++, R.id.levelsTheSokEvoCollectionButton);

		// Marko Dzekic
		levelSetButtonMap.put(i++, R.id.levelsComplexSimplicityButton);
		levelSetButtonMap.put(i++, R.id.levelsGaladrielButton);
		levelSetButtonMap.put(i++, R.id.levelsMarkoDzekicButton);
		levelSetButtonMap.put(i++, R.id.levelsAmazingOrimazingButton);
		levelSetButtonMap.put(i++, R.id.levelsRemodelingButton);
		levelSetButtonMap.put(i++, R.id.levelsSokoSpaceButton);

		// Sven Egevad
		levelSetButtonMap.put(i++, R.id.levelsSharpenCollectionButton);
		levelSetButtonMap.put(i++, R.id.levelsSvensCollectionButton);
		levelSetButtonMap.put(i++, R.id.levelsYasgood2Button);

		// Thomas Reinke
		levelSetButtonMap.put(i++, R.id.levels81Button);
		levelSetButtonMap.put(i++, R.id.levelsAlbiziaButton);
		levelSetButtonMap.put(i++, R.id.levelsAnomalyButton);
		levelSetButtonMap.put(i++, R.id.levelsCalxButton);
		levelSetButtonMap.put(i++, R.id.levelsPateraButton);
		levelSetButtonMap.put(i++, R.id.levelsSokomaniaButton);
		levelSetButtonMap.put(i++, R.id.levelsTBoxButton);
		levelSetButtonMap.put(i++, R.id.levelsTBox2Button);
		levelSetButtonMap.put(i++, R.id.levelsTBox3Button);
		levelSetButtonMap.put(i++, R.id.levelsTBox4Button);
		levelSetButtonMap.put(i++, R.id.levelsTBox5Button);
		levelSetButtonMap.put(i++, R.id.levelsYASGoodButton);
		levelSetButtonMap.put(i++, R.id.levelsAnomaly2Button);
		levelSetButtonMap.put(i++, R.id.levelsAnomaly3Button);
		levelSetButtonMap.put(i++, R.id.levelsQuagmireButton);
		levelSetButtonMap.put(i++, R.id.levelsQuagmire2Button);
		levelSetButtonMap.put(i++, R.id.levelsQuagmire3Button);
		levelSetButtonMap.put(i++, R.id.levelsScoriaButton);
		levelSetButtonMap.put(i++, R.id.levelsScoria2Button);
		levelSetButtonMap.put(i++, R.id.levelsScoria3Button);

		// Misc. authors
		levelSetButtonMap.put(i++, R.id.levelsFPokornyCollectionButton);
		levelSetButtonMap.put(i++, R.id.levelsSylvieButton);

		// A1master
		levelSetButtonMap.put(i++, R.id.levels1000001CandlelightsButton);
		levelSetButtonMap.put(i++, R.id.levels1000002CandlelightsButton);

		// Vipul Patel
		levelSetButtonMap.put(i++, R.id.levels100000MovesOnlyButton);
		levelSetButtonMap.put(i++, R.id.levelsGrigrChallengeRemodeledButton);
		levelSetButtonMap.put(i++, R.id.levelsMastervipButton);
		levelSetButtonMap.put(i++, R.id.levelsMaximum100000MovesButton);
		levelSetButtonMap.put(i++, R.id.levelsNamoButton);
		levelSetButtonMap.put(i++, R.id.levelsSokocrisisButton);
		levelSetButtonMap.put(i++, R.id.levelsSokodealButton);
		levelSetButtonMap.put(i++, R.id.levelsSokophobiaButton);

		// xbluejimx
		levelSetButtonMap.put(i++, R.id.levels12BlocksButton);
		levelSetButtonMap.put(i++, R.id.levels4RECButton);

		// Carlos Montiers
		levelSetButtonMap.put(i++, R.id.levels23x11Button);
		levelSetButtonMap.put(i++, R.id.levelsInitiationButton);

		// Dries de Clercq
		levelSetButtonMap.put(i++, R.id.levels696Button);
		levelSetButtonMap.put(i++, R.id.levelsBlocksButton);
		levelSetButtonMap.put(i++, R.id.levelsGateButton);
		levelSetButtonMap.put(i++, R.id.levelsLinedButton);
		levelSetButtonMap.put(i++, R.id.levelsMillButton);
		levelSetButtonMap.put(i++, R.id.levelsOrimazeVariationsButton);
		levelSetButtonMap.put(i++, R.id.levelsOrimazeButton);
		levelSetButtonMap.put(i++, R.id.levelsOrimaze2Button);
		levelSetButtonMap.put(i++, R.id.levelsRectangledButton);
		levelSetButtonMap.put(i++, R.id.levelsSquaredButton);
		levelSetButtonMap.put(i++, R.id.levelsVariousButton);
		levelSetButtonMap.put(i++, R.id.levelsZone26Button);

		// Archanfel
		levelSetButtonMap.put(i++, R.id.levelsABHT01Button);
		levelSetButtonMap.put(i++, R.id.levelsABHT02Button);
		levelSetButtonMap.put(i++, R.id.levelsABHT03Button);
		levelSetButtonMap.put(i++, R.id.levelsGameOfThronesButton);

		// Andrej Cerjak
		levelSetButtonMap.put(i++, R.id.levelsACSmileys4Button);
		levelSetButtonMap.put(i++, R.id.levelsACDiamondsButton);
		levelSetButtonMap.put(i++, R.id.levelsACEasyButton);
		levelSetButtonMap.put(i++, R.id.levelsACSelectedButton);
		levelSetButtonMap.put(i++, R.id.levelsACSmileysButton);
		levelSetButtonMap.put(i++, R.id.levelsACSmileys2Button);
		levelSetButtonMap.put(i++, R.id.levelsACSmileys3Button);
		levelSetButtonMap.put(i++, R.id.levelsPassingByButton);

		// Péter Asztalos
		levelSetButtonMap.put(i++, R.id.levelsAKKInformatikaButton);

		// Andre Bernier
		levelSetButtonMap.put(i++, R.id.levelsInitialTroubleButton);

		// Razorflame
		levelSetButtonMap.put(i++, R.id.levelsAeternusButton);
		levelSetButtonMap.put(i++, R.id.levelsAttritionButton);
		levelSetButtonMap.put(i++, R.id.levelsAttrition05Button);
		levelSetButtonMap.put(i++, R.id.levelsAttrition2Button);
		levelSetButtonMap.put(i++, R.id.levelsAttrition3Button);
		levelSetButtonMap.put(i++, R.id.levelsAttrition4Button);
		levelSetButtonMap.put(i++, R.id.levelsChaoticCatalystsButton);
		levelSetButtonMap.put(i++, R.id.levelsCompactCatalystsButton);
		levelSetButtonMap.put(i++, R.id.levelsCompactCatalysts02Button);
		levelSetButtonMap.put(i++, R.id.levelsFieryCatalystsButton);
		levelSetButtonMap.put(i++, R.id.levelsIonicCatalystsButton);
		levelSetButtonMap.put(i++, R.id.levelsIonicCatalystsReprisal01Button);
		levelSetButtonMap.put(i++, R.id.levelsIonicCatalystsReprisal02Button);
		levelSetButtonMap.put(i++, R.id.levelsLexicalCatalystsButton);
		levelSetButtonMap.put(i++, R.id.levelsLongevityButton);

		// Alberto Borella
		levelSetButtonMap.put(i++, R.id.levelsAlbeButton);

		// Alberto Garcia, Spiros Mantzoukis
		levelSetButtonMap.put(i++, R.id.levelsAlbertoGarciaArrangedButton);

		// Zhenying, others
		levelSetButtonMap.put(i++, R.id.levelsAllRemodelsButton);

		// Michael C Falk
		levelSetButtonMap.put(i++, R.id.levelsAlphabetSoupButton);

		// Milutin Negovanovic
		levelSetButtonMap.put(i++, R.id.levelsArmadaCollection1Button);
		levelSetButtonMap.put(i++, R.id.levelsAvalaButton);
		levelSetButtonMap.put(i++, R.id.levelsHelpButton);
		levelSetButtonMap.put(i++, R.id.levelsMitijaButton);
		levelSetButtonMap.put(i++, R.id.levelsMitija1Button);
		levelSetButtonMap.put(i++, R.id.levelsMitija2Button);
		levelSetButtonMap.put(i++, R.id.levelsMitija3Button);
		levelSetButtonMap.put(i++, R.id.levelsMitija4Button);
		levelSetButtonMap.put(i++, R.id.levelsRebus1Button);
		levelSetButtonMap.put(i++, R.id.levelsRedStarButton);

		// Tolle
		levelSetButtonMap.put(i++, R.id.levelsBackToOriginsButton);

		// Zivojin Trifunovic
		levelSetButtonMap.put(i++, R.id.levelsBanjaKoviljacaButton);
		levelSetButtonMap.put(i++, R.id.levelsCerButton);
		levelSetButtonMap.put(i++, R.id.levelsDrinaButton);
		levelSetButtonMap.put(i++, R.id.levelsDunavButton);
		levelSetButtonMap.put(i++, R.id.levelsFontanaButton);
		levelSetButtonMap.put(i++, R.id.levelsGucevoButton);
		levelSetButtonMap.put(i++, R.id.levelsPacovButton);
		levelSetButtonMap.put(i++, R.id.levelsParkButton);
		levelSetButtonMap.put(i++, R.id.levelsPauljeButton);
		levelSetButtonMap.put(i++, R.id.levelsPiramidaButton);
		levelSetButtonMap.put(i++, R.id.levelsPodrinjeButton);
		levelSetButtonMap.put(i++, R.id.levelsZikaButton);
		levelSetButtonMap.put(i++, R.id.levelsZika1Button);

		// Stanislav Kanev
		levelSetButtonMap.put(i++, R.id.levelsBaronaButton);

		// Eduardo Santos
		levelSetButtonMap.put(i++, R.id.levelsBeijingOlympicsButton);

		// Martí Homs Caussa
		levelSetButtonMap.put(i++, R.id.levelsSmallerThinnerEasierBetterButton);
		levelSetButtonMap.put(i++, R.id.levelsBoringButton);
		levelSetButtonMap.put(i++, R.id.levelsChoribanLevelsButton);
		levelSetButtonMap.put(i++, R.id.levelsHomzLevelsPartIIButton);
		levelSetButtonMap.put(i++, R.id.levelsFunnyTemplateLevelsButton);
		levelSetButtonMap.put(i++, R.id.levelsHomzLevelsButton);
		levelSetButtonMap.put(i++, R.id.levelsMapsAfterAllButton);
		levelSetButtonMap.put(i++, R.id.levelsPicolevelsButton);

		// Milan Vukosavljevic
		levelSetButtonMap.put(i++, R.id.levelsBigBenButton);
		levelSetButtonMap.put(i++, R.id.levelsStariFijakerButton);
		levelSetButtonMap.put(i++, R.id.levelsBeearButton);

		// Blaz Nikolic
		levelSetButtonMap.put(i++, R.id.levelsBlazzButton);
		levelSetButtonMap.put(i++, R.id.levelsBlazz2Button);

		// zxretrosoft
		levelSetButtonMap.put(i++, R.id.levelsBrainsportExtremeButton);
		levelSetButtonMap.put(i++, R.id.levelsSokobanExtremeButton);

		// Eric F Tchong, Premysil Zika
		levelSetButtonMap.put(i++, R.id.levelsBravoPremysilZikaButton);

		// Jorge Gloria
		levelSetButtonMap.put(i++, R.id.levelsBrunaMariaButton);
		levelSetButtonMap.put(i++, R.id.levelsClassicButton);
		levelSetButtonMap.put(i++, R.id.levelsEasy5BoxesButton);
		levelSetButtonMap.put(i++, R.id.levelsSaquaremaButton);

		// Bruno Druille
		levelSetButtonMap.put(i++, R.id.levelsBrunoDruilleButton);

		// Buddy Casamis
		levelSetButtonMap.put(i++, R.id.levelsBugs1005CollectionsButton);
		levelSetButtonMap.put(i++, R.id.levelsBugsCollection138Button);
		levelSetButtonMap.put(i++, R.id.levelsBugsCollection2Button);
		levelSetButtonMap.put(i++, R.id.levelsBugsCollection3Button);
		levelSetButtonMap.put(i++, R.id.levelsBugs509CollectionButton);
		levelSetButtonMap.put(i++, R.id.levelsBugs550CollectionButton);
		levelSetButtonMap.put(i++, R.id.levelsBugsCollection97Button);
		levelSetButtonMap.put(i++, R.id.levelsBugsSpecialCollectionButton);
		levelSetButtonMap.put(i++, R.id.levelsGrigChallengeVariationButton);
		levelSetButtonMap.put(i++, R.id.levelsMoreBugsCollectionsButton);
		levelSetButtonMap.put(i++, R.id.levelsBugsCollectionButton);

		// MVP Software
		levelSetButtonMap.put(i++, R.id.levelsCargoBayDeluxeButton);

		// David Buchweitz
		levelSetButtonMap.put(i++, R.id.levelsChrysalisCollection2Button);
		levelSetButtonMap.put(i++, R.id.levelsChrysalisCollection3Button);
		levelSetButtonMap.put(i++, R.id.levelsChrysalisCollection4Button);
		levelSetButtonMap.put(i++, R.id.levelsChrysalisCollection10Button);
		levelSetButtonMap.put(i++, R.id.levelsChrysalisCollection5Button);
		levelSetButtonMap.put(i++, R.id.levelsChrysalisCollection6Button);
		levelSetButtonMap.put(i++, R.id.levelsChrysalisCollection7Button);
		levelSetButtonMap.put(i++, R.id.levelsChrysalisCollection8Button);
		levelSetButtonMap.put(i++, R.id.levelsChrysalisCollection9Button);
		levelSetButtonMap.put(i++, R.id.levelsChrysalisCollectionButton);

		// Various Authors
		levelSetButtonMap.put(i++, R.id.levelsCocktailButton);
		levelSetButtonMap.put(i++, R.id.levelsSokobigRemodelsButton);
		levelSetButtonMap.put(i++, R.id.levelsFunLevelsButton);

		// Vladimir Tockic
		levelSetButtonMap.put(i++, R.id.levelsVladimirTockicCollection2DemoButton);
		levelSetButtonMap.put(i++, R.id.levelsVladimirTockicCollectionButton);

		// jhogloria
		levelSetButtonMap.put(i++, R.id.levelsCookieButton);

		// MB
		levelSetButtonMap.put(i++, R.id.levelsCSokoButton);

		// David Dahlem
		levelSetButtonMap.put(i++, R.id.levelsDD1Button);
		levelSetButtonMap.put(i++, R.id.levelsDD2Button);

		// Crazy Monk
		levelSetButtonMap.put(i++, R.id.levelsDiscipleButton);

		// Schindler Zoltán
		levelSetButtonMap.put(i++, R.id.levelsErikaButton);

		// Erim Sever
		levelSetButtonMap.put(i++, R.id.levelsErimSeverCollectionButton);

		// niwa
		levelSetButtonMap.put(i++, R.id.levelsEscapologyButton);
		levelSetButtonMap.put(i++, R.id.levelsPetitesseButton);
		levelSetButtonMap.put(i++, R.id.levelsSquareDanceButton);

		// Pat Perrodon
		levelSetButtonMap.put(i++, R.id.levelsFauxPasButton);

		// Kevin Cassol
		levelSetButtonMap.put(i++, R.id.levelsFibonacciChallengeButton);
		levelSetButtonMap.put(i++, R.id.levelsSokoChallengeButton);

		// Dries de Clercq, Marko Dzekic
		levelSetButtonMap.put(i++, R.id.levelsFiveBrothersButton);

		// Edwin Abbot
		levelSetButtonMap.put(i++, R.id.levelsFlatlandButton);

		// Tim LeFevre
		levelSetButtonMap.put(i++, R.id.levelsFlyButton);

		// Gabi Hanisch
		levelSetButtonMap.put(i++, R.id.levelsGabiAndJennyButton);

		// Ghislain Martin
		levelSetButtonMap.put(i++, R.id.levelsGhislainMartinArrangedButton);
		levelSetButtonMap.put(i++, R.id.levelsMondeButton);
		levelSetButtonMap.put(i++, R.id.levelsSokoStationButton);

		// Mike McKee, Joe Hitchens
		levelSetButtonMap.put(i++, R.id.levelsGreenMachineButton);

		// Guichard
		levelSetButtonMap.put(i++, R.id.levelsGuichardButton);

		// Gyjgw
		levelSetButtonMap.put(i++, R.id.levelsGyjgwArrangedButton);
		levelSetButtonMap.put(i++, R.id.levelsGyjgwCollectionButton);

		// Richard Weston
		levelSetButtonMap.put(i++, R.id.levelsRichardWestonCollectionButton);

		// Ian Hammond
		levelSetButtonMap.put(i++, R.id.levelsBrainsportButton);

		// DrFogh
		levelSetButtonMap.put(i++, R.id.levelsItsAllGreekButton);
		levelSetButtonMap.put(i++, R.id.levelsNumbersByDrFoghButton);
		levelSetButtonMap.put(i++, R.id.levelsOriginal01Button);
		levelSetButtonMap.put(i++, R.id.levelsOriginal02Button);
		levelSetButtonMap.put(i++, R.id.levelsOriginal3Button);
		levelSetButtonMap.put(i++, R.id.levelsSokobetButton);

		// Ivelin Georgiev Ivanov
		levelSetButtonMap.put(i++, R.id.levelsTheAdventurerButton);

		// Kobus Theron
		levelSetButtonMap.put(i++, R.id.levelsKobusTheronCollectionButton);

		// Jean-Pierre Kent
		levelSetButtonMap.put(i++, R.id.levelsJeanPierreKentButton);

		// Kenya Maruyama
		levelSetButtonMap.put(i++, R.id.levelsKenyamSetAButton);

		// Keijo Sopuli
		levelSetButtonMap.put(i++, R.id.levelsKEASCollectionButton);

		// Kevin B Reilly
		levelSetButtonMap.put(i++, R.id.levelsKevin01Button);
		levelSetButtonMap.put(i++, R.id.levelsKevin02Button);
		levelSetButtonMap.put(i++, R.id.levelsKevin03Button);
		levelSetButtonMap.put(i++, R.id.levelsKevin04Button);
		levelSetButtonMap.put(i++, R.id.levelsKevin05Button);
		levelSetButtonMap.put(i++, R.id.levelsKevin06Button);
		levelSetButtonMap.put(i++, R.id.levelsKevin07Button);
		levelSetButtonMap.put(i++, R.id.levelsKevin08Button);
		levelSetButtonMap.put(i++, R.id.levelsKevin09Button);
		levelSetButtonMap.put(i++, R.id.levelsKevin10Button);
		levelSetButtonMap.put(i++, R.id.levelsKevin11Button);
		levelSetButtonMap.put(i++, R.id.levelsKevin12Button);
		levelSetButtonMap.put(i++, R.id.levelsKevin13Button);
		levelSetButtonMap.put(i++, R.id.levelsKevin14Button);
		levelSetButtonMap.put(i++, R.id.levelsKevin15Button);
		levelSetButtonMap.put(i++, R.id.levelsKevin16Button);
		levelSetButtonMap.put(i++, R.id.levelsKevin17Button);
		levelSetButtonMap.put(i++, R.id.levelsKevin18Button);
		levelSetButtonMap.put(i++, R.id.levelsKevin19Button);
		levelSetButtonMap.put(i++, R.id.levelsKevin20Button);
		levelSetButtonMap.put(i++, R.id.levelsKevin21Button);
		levelSetButtonMap.put(i++, R.id.levelsKevinBReillyArrangedButton);

		// Konstantinos Bozeberg
		levelSetButtonMap.put(i++, R.id.levelsKosButton);

		// Kurt Nittel
		levelSetButtonMap.put(i++, R.id.levelsKurtNittel1Button);
		levelSetButtonMap.put(i++, R.id.levelsKurtNittel2Button);

		// Laizhufu, LZY
		levelSetButtonMap.put(i++, R.id.levelsLaizhufuAndLZYArrangedButton);

		// Draku
		levelSetButtonMap.put(i++, R.id.levelsLearningSokobanButton);

		// Li Jin You
		levelSetButtonMap.put(i++, R.id.levelsLiJinYouCollectionButton);

		// Many Authors, see each level
		levelSetButtonMap.put(i++, R.id.levelsLomaButton);
		levelSetButtonMap.put(i++, R.id.levelsMassRemodelButton);
		levelSetButtonMap.put(i++, R.id.levelsVolatileCatalystsButton);

		// MF8: Many authors
		levelSetButtonMap.put(i++, R.id.levelsMF8SokobanCompetitionButton);

		// MacTommy
		levelSetButtonMap.put(i++, R.id.levelsMacTommyInventionsButton);

		// Ward De Langhe
		levelSetButtonMap.put(i++, R.id.levelsMagicPearlsButton);
		levelSetButtonMap.put(i++, R.id.levelsMoreMagicPearlsButton);

		// Reinhard Hielscher
		levelSetButtonMap.put(i++, R.id.levelsManyBoxesButton);

		// Marcus Palstra
		levelSetButtonMap.put(i++, R.id.levelsMarcusPalstraButton);

		// Mario Bonenfant
		levelSetButtonMap.put(i++, R.id.levelsMarioBonenfantCollectionButton);

		// rikitin
		levelSetButtonMap.put(i++, R.id.levelsMariposaButton);
		levelSetButtonMap.put(i++, R.id.levelsRikymanButton);

		// Union Software of Silesia
		levelSetButtonMap.put(i++, R.id.levelsMasterHeadButton);

		// York Shen
		levelSetButtonMap.put(i++, R.id.levelsMicroban01ArrangedButton);
		levelSetButtonMap.put(i++, R.id.levelsMicroban02ArrangedButton);
		levelSetButtonMap.put(i++, R.id.levelsSasquatch01ArrangedButton);
		levelSetButtonMap.put(i++, R.id.levelsSasquatch02ArrangedButton);
		levelSetButtonMap.put(i++, R.id.levelsSasquatch03ArrangedButton);
		levelSetButtonMap.put(i++, R.id.levelsSasquatch04ArrangedButton);
		levelSetButtonMap.put(i++, R.id.levelsSasquatch05ArrangedButton);
		levelSetButtonMap.put(i++, R.id.levelsSasquatch06ArrangedButton);
		levelSetButtonMap.put(i++, R.id.levelsSasquatch07ArrangedButton);
		levelSetButtonMap.put(i++, R.id.levelsYorkShenCollectionButton);

		// Dries de Clercq, Mark, anian
		levelSetButtonMap.put(i++, R.id.levelsMillRemodelButton);

		// monry
		levelSetButtonMap.put(i++, R.id.levelsMonryCollectionButton);

		// monry, Panda
		levelSetButtonMap.put(i++, R.id.levelsMonryAndPandaArrangedButton);

		// Hirohiko Nakamiya
		levelSetButtonMap.put(i++, R.id.levelsMonsterSokobanButton);
		levelSetButtonMap.put(i++, R.id.levelsNakamiyaButton);
		levelSetButtonMap.put(i++, R.id.levelsNakamiyaJoyButton);
		levelSetButtonMap.put(i++, R.id.levelsNakamiyaLimitButton);
		levelSetButtonMap.put(i++, R.id.levelsNakamiyaPracticeButton);

		// Shaggath
		levelSetButtonMap.put(i++, R.id.levelsMulholland2Button);
		levelSetButtonMap.put(i++, R.id.levelsMulhollandDButton);
		levelSetButtonMap.put(i++, R.id.levelsV2009Button);
		levelSetButtonMap.put(i++, R.id.levelsV2010Button);
		levelSetButtonMap.put(i++, R.id.levelsV2014Button);

		// DrFogh, Archanfel, Joseph L Traub
		levelSetButtonMap.put(i++, R.id.levelsOriginalExtraSharpenButton);

		// Findus
		levelSetButtonMap.put(i++, R.id.levelsPayback01Button);
		levelSetButtonMap.put(i++, R.id.levelsPayback02Button);
		levelSetButtonMap.put(i++, R.id.levelsPayback03Button);
		levelSetButtonMap.put(i++, R.id.levelsPayback04Button);
		levelSetButtonMap.put(i++, R.id.levelsPayback05Button);
		levelSetButtonMap.put(i++, R.id.levelsPayback06Button);
		levelSetButtonMap.put(i++, R.id.levelsPayback07Button);
		levelSetButtonMap.put(i++, R.id.levelsPayback08Button);
		levelSetButtonMap.put(i++, R.id.levelsPayback09Button);
		levelSetButtonMap.put(i++, R.id.levelsPayback10Button);

		// Perka
		levelSetButtonMap.put(i++, R.id.levelsJokeButton);

		// Morganine
		levelSetButtonMap.put(i++, R.id.levelsRandomsButton);

		// Roger Delaporte
		levelSetButtonMap.put(i++, R.id.levelsRdlomButton);
		levelSetButtonMap.put(i++, R.id.levelsRogerDelaporteButton);

		// Marcus Hof
		levelSetButtonMap.put(i++, R.id.levelsRevenge13Button);
		levelSetButtonMap.put(i++, R.id.levelsRevenge14Button);
		levelSetButtonMap.put(i++, R.id.levelsRevenge15Button);
		levelSetButtonMap.put(i++, R.id.levelsRevenge16Button);
		levelSetButtonMap.put(i++, R.id.levelsRevenge17Button);
		levelSetButtonMap.put(i++, R.id.levelsRevenge18Button);
		levelSetButtonMap.put(i++, R.id.levelsRevenge19Button);
		levelSetButtonMap.put(i++, R.id.levelsRevenge20Button);
		levelSetButtonMap.put(i++, R.id.levelsRevenge21Button);
		levelSetButtonMap.put(i++, R.id.levelsRevenge22Button);
		levelSetButtonMap.put(i++, R.id.levelsRevenge23Button);
		levelSetButtonMap.put(i++, R.id.levelsRevenge24Button);
		levelSetButtonMap.put(i++, R.id.levelsRevenge25Button);
		levelSetButtonMap.put(i++, R.id.levelsRevenge26Button);
		levelSetButtonMap.put(i++, R.id.levelsRevenge27Button);
		levelSetButtonMap.put(i++, R.id.levelsRevenge28Button);
		levelSetButtonMap.put(i++, R.id.levelsRevenge29Button);
		levelSetButtonMap.put(i++, R.id.levelsRevenge30Button);
		levelSetButtonMap.put(i++, R.id.levelsRevenge31Button);
		levelSetButtonMap.put(i++, R.id.levelsRevenge32Button);
		levelSetButtonMap.put(i++, R.id.levelsRevenge33Button);
		levelSetButtonMap.put(i++, R.id.levelsRevenge34Button);
		levelSetButtonMap.put(i++, R.id.levelsRevenge35Button);
		levelSetButtonMap.put(i++, R.id.levelsRevenge36Button);
		levelSetButtonMap.put(i++, R.id.levelsRevenge37Button);
		levelSetButtonMap.put(i++, R.id.levelsRevenge38Button);
		levelSetButtonMap.put(i++, R.id.levelsRevenge39Button);
		levelSetButtonMap.put(i++, R.id.levelsRevengeCollection01Button);
		levelSetButtonMap.put(i++, R.id.levelsRevengeCollection02Button);
		levelSetButtonMap.put(i++, R.id.levelsRevengeCollection03Button);
		levelSetButtonMap.put(i++, R.id.levelsRevengeCollection04Button);
		levelSetButtonMap.put(i++, R.id.levelsRevengeCollection05Button);
		levelSetButtonMap.put(i++, R.id.levelsRevengeCollection06Button);
		levelSetButtonMap.put(i++, R.id.levelsRevengeCollection07Button);
		levelSetButtonMap.put(i++, R.id.levelsRevengeCollection08Button);
		levelSetButtonMap.put(i++, R.id.levelsRevengeCollection09Button);
		levelSetButtonMap.put(i++, R.id.levelsRevengeCollection10Button);
		levelSetButtonMap.put(i++, R.id.levelsRevengeCollection11Button);
		levelSetButtonMap.put(i++, R.id.levelsRevengeCollection12Button);

		// TIAOA
		levelSetButtonMap.put(i++, R.id.levelsSBMendonca01Button);
		levelSetButtonMap.put(i++, R.id.levelsSBMendonca02Button);
		levelSetButtonMap.put(i++, R.id.levelsSBMendonca03Button);
		levelSetButtonMap.put(i++, R.id.levelsSBMendonca04Button);
		levelSetButtonMap.put(i++, R.id.levelsSBMendonca05Button);
		levelSetButtonMap.put(i++, R.id.levelsSBMendonca06Button);
		levelSetButtonMap.put(i++, R.id.levelsSBMendoncaLivresButton);
		levelSetButtonMap.put(i++, R.id.levelsSBMendoncaModificationsButton);
		levelSetButtonMap.put(i++, R.id.levelsSBMendoncaRemodeledButton);

		// Muhammad Umar
		levelSetButtonMap.put(i++, R.id.levelsTheFirstOneButton);

		// Pøemysl Zíka
		levelSetButtonMap.put(i++, R.id.levelsSecundusGradusAdOlympoButton);
		levelSetButtonMap.put(i++, R.id.levelsTertiusGradusAdOlympo1Button);

		// Serg Belyaev
		levelSetButtonMap.put(i++, R.id.levelsSergBelyaev1Button);
		levelSetButtonMap.put(i++, R.id.levelsSergBelyaev2Button);
		levelSetButtonMap.put(i++, R.id.levelsSergBelyaev3Button);
		levelSetButtonMap.put(i++, R.id.levelsSergBelyaev4Button);
		levelSetButtonMap.put(i++, R.id.levelsSergBelyaev5Button);
		levelSetButtonMap.put(i++, R.id.levelsSergBelyaev6Button);

		// Phil Shapiro
		levelSetButtonMap.put(i++, R.id.levelsSimpleCollectionButton);

		// yotyot
		levelSetButtonMap.put(i++, R.id.levelsSimplisticButton);

		// Lars Nilsson
		levelSetButtonMap.put(i++, R.id.levelsSimplyButton);
		levelSetButtonMap.put(i++, R.id.levelsSokoLasseButton);
		levelSetButtonMap.put(i++, R.id.levelsSokolasse2Button);

		// Kevin B Reilly, Gerald Holler
		levelSetButtonMap.put(i++, R.id.levelsSokoMindButton);

		// Wayne Campbell
		levelSetButtonMap.put(i++, R.id.levelsSokobanOriginalPuzzlesTributeLButton);

		// Einar Saukas
		levelSetButtonMap.put(i++, R.id.levelsSokoBonusButton);

		// Laura Wheeler
		levelSetButtonMap.put(i++, R.id.levelsSokobanJunior1Button);
		levelSetButtonMap.put(i++, R.id.levelsSokobanJunior2Button);

		// PK2497
		levelSetButtonMap.put(i++, R.id.levelsSokoking01Button);

		// Matthias 'muh' Pauligk
		levelSetButtonMap.put(i++, R.id.levelsTheSolversUnsolvableButton);
		levelSetButtonMap.put(i++, R.id.levelsSundayWarmupButton);

		// Aleksey Krupenko
		levelSetButtonMap.put(i++, R.id.levelsSonicButton);
		levelSetButtonMap.put(i++, R.id.levelsSonic2Button);
		levelSetButtonMap.put(i++, R.id.levelsSonic3Button);

		// Kseniya Mierzejewska
		levelSetButtonMap.put(i++, R.id.levelsSpiralsButton);

		// Spiros Mantzoukis
		levelSetButtonMap.put(i++, R.id.levelsSpiros01Button);
		levelSetButtonMap.put(i++, R.id.levelsSpiros02Button);
		levelSetButtonMap.put(i++, R.id.levelsSpiros03Button);
		levelSetButtonMap.put(i++, R.id.levelsSpiros04Button);
		levelSetButtonMap.put(i++, R.id.levelsSpiros05Button);
		levelSetButtonMap.put(i++, R.id.levelsSpiros06Button);
		levelSetButtonMap.put(i++, R.id.levelsSpiros07Button);
		levelSetButtonMap.put(i++, R.id.levelsSpiros8Button);

		// J Franklin Mentzer
		levelSetButtonMap.put(i++, R.id.levelsStillMoreCollectionButton);

		// Sylvain Gravejat, Guillaume Gravejat
		levelSetButtonMap.put(i++, R.id.levelsSylvainGravejatButton);

		// Seppolino
		levelSetButtonMap.put(i++, R.id.levelsSymmetrixxButton);

		// Ken'ichiro Takahashi (takaken)
		levelSetButtonMap.put(i++, R.id.levelsTakakenCollectionButton);

		// Mark
		levelSetButtonMap.put(i++, R.id.levelsTheHouseButton);

		// XiBei Tian Lang
		levelSetButtonMap.put(i++, R.id.levelsTianLangButton);

		// John Polhemus
		levelSetButtonMap.put(i++, R.id.levelsTitleScreensButton);

		// Wilfrid Geiser
		levelSetButtonMap.put(i++, R.id.levelsTrapdooooooooorsButton);

		// Martin P Holland
		levelSetButtonMap.put(i++, R.id.levelsTwistyButton);

		// W M Dekker
		levelSetButtonMap.put(i++, R.id.levelsSoundextensionsAndCirclesButton);

		// Rick Sladkey
		levelSetButtonMap.put(i++, R.id.levelsTheWarehouseIVerticalMobilityButton);

		// Iroh
		levelSetButtonMap.put(i++, R.id.levelsWarehouseButton);

		// Brian Damgaard
		levelSetButtonMap.put(i++, R.id.levelsYASGenButton);

		// Yut
		levelSetButtonMap.put(i++, R.id.levelsYutButton);

		// Zbigniew Kornas
		levelSetButtonMap.put(i++, R.id.levelsZbigniewKornasButton);

		// Zeljko Negovanovic
		levelSetButtonMap.put(i++, R.id.levelsZeljaButton);
		levelSetButtonMap.put(i++, R.id.levelsZelja1Button);

		// Brian Kent
		levelSetButtonMap.put(i++, R.id.levelsBrianKentsSokoban2KButton);

		// Doreen Kaufmann, Rainer Kaufmann
		levelSetButtonMap.put(i++, R.id.levelsDemonsAndDiamondsButton);
		levelSetButtonMap.put(i++, R.id.levelsCubesAndTubesButton);

		// Frantisek Pokorny
		levelSetButtonMap.put(i++, R.id.levelsFrantisekPokornyCollectionButton);

		// John C Davis
		levelSetButtonMap.put(i++, R.id.levelsJCDLevelsButton);

		// Joris Wit
		levelSetButtonMap.put(i++, R.id.levelsJw2005Button);

		// Karl-Heinz Böhm
		levelSetButtonMap.put(i++, R.id.levelsKalle1Button);

		// Kirill
		levelSetButtonMap.put(i++, R.id.levelsKisserButton);

		// 00XIAN
		levelSetButtonMap.put(i++, R.id.levelsOoxianButton);
	}

	// Key = Button ID
	// Value = Level set
	private static Map<Integer, Integer> levelSetButtonReverseMap = new HashMap<Integer, Integer>();
	static {
		for (Map.Entry<Integer, Integer> entry : levelSetButtonMap.entrySet()) {
			levelSetButtonReverseMap.put(entry.getValue(), entry.getKey());
		}
	}

	public static int getButtonIdFromLevelSetIndex(int levelSetIndex) {
		return levelSetButtonMap.get(levelSetIndex);
	}

	public static int getLevelSetIndexFromButtonId(int buttonId) {
		return levelSetButtonReverseMap.get(buttonId);
	}

	public String getLevelSetName(int levelSetIndex) {
		int buttonId = getButtonIdFromLevelSetIndex(levelSetIndex);
		return this.getLevelSetName((Button) findViewById(buttonId));
	}
	public String getLevelSetName(Button button) {
		String levelSetName = button == null ? "Unknown" : button.getText().toString();

		// Remove the " - X/XXX" at the end of the button label, to get the level set name.
		return levelSetName.replaceAll(" - \\d+/\\d+$", "");
	}

	public void setLastLevelSetIndex(int levelSetIndex) {
		SharedPreferences prefs = getSharedPreferences(SHARED_PREFS_NAME, MODE_PRIVATE);
		Editor editor = prefs.edit();
		editor.putInt(LAST_LEVELSET_NAME, levelSetIndex);
		editor.commit();
		this.lastLevelIndex = levelSetIndex;
	}
	public int getLastLevelSetIndex() {
		if (this.lastLevelIndex == -1) {
			SharedPreferences prefs = getSharedPreferences(SHARED_PREFS_NAME, MODE_PRIVATE);
			this.lastLevelIndex = prefs.getInt(LAST_LEVELSET_NAME, -2);
		}
		return this.lastLevelIndex;
	}

	public void onButtonClicked(View view) {
		final int levelSetIndex = getLevelSetIndexFromButtonId(view.getId());
		this.setLastLevelSetIndex(levelSetIndex);

		SharedPreferences prefs = getSharedPreferences(SHARED_PREFS_NAME, MODE_PRIVATE);
		final String maxLevelNamePref = getMaxLevelPrefName(levelSetIndex);
		final int maxLevel = Math.min(prefs.getInt(maxLevelNamePref, 1),
				SokobanLevels.levelMaps.get(levelSetIndex).length);

		final String levelSetName = this.getLevelSetName(levelSetIndex);

		if (maxLevel == 1) {
			Intent intent = new Intent();
			intent.putExtra(SokobanGameActivity.GAME_LEVEL_INTENT_EXTRA, 0);
			intent.putExtra(SokobanGameActivity.GAME_LEVEL_SET_EXTRA, levelSetIndex);
			intent.putExtra(SokobanGameActivity.GAME_LEVEL_SET_NAME_EXTRA, levelSetName);
			intent.putExtra(SokobanGameActivity.SHOW_HELP_INTENT_EXTRA, true);
			intent.setClass(this, SokobanGameActivity.class);
			startActivity(intent);
		} else {
			List<String> levelList = new ArrayList<String>(maxLevel);
			for (int i = maxLevel; i > 0; i--) {
				levelList.add("Level " + i);
			}
			final String[] items = levelList.toArray(new String[maxLevel]);
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setTitle("Choose level");
			builder.setItems(items, new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int item) {
					Intent intent = new Intent();
					int levelClicked = maxLevel - item - 1;
					intent.putExtra(SokobanGameActivity.GAME_LEVEL_SET_EXTRA, levelSetIndex);
					intent.putExtra(SokobanGameActivity.GAME_LEVEL_SET_NAME_EXTRA, levelSetName);
					intent.putExtra(SokobanGameActivity.GAME_LEVEL_INTENT_EXTRA, levelClicked);
					intent.setClass(SokobanLevelMenuActivity.this, SokobanGameActivity.class);
					startActivity(intent);
				}
			});
			builder.create().show();
		}
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.levelsets);
	}

	@Override
	protected void onResume() {
		super.onResume();

		for (int i=0; i<levelSetButtonMap.size(); i++) {
			setButtonText(getButtonIdFromLevelSetIndex(i), i);
		}
	}

	public static int getMaxLevel(int levelSetIndex, Context context) {
		SharedPreferences prefs = context.getSharedPreferences(SHARED_PREFS_NAME, MODE_PRIVATE);
		final String maxLevelNamePref = getMaxLevelPrefName(levelSetIndex);
		return Math.min(prefs.getInt(maxLevelNamePref, 1), SokobanLevels.levelMaps.get(levelSetIndex).length);
	}

	private void setButtonText(int buttonId, int levelSetIndex) {
		Button button = (Button) findViewById(buttonId);
		String buttonText = getLevelSetName(button);

		if (levelSetIndex == this.getLastLevelSetIndex()) {
			// Highlight the button: Bold text, purple button
			button.setTypeface(Typeface.DEFAULT_BOLD);
			button.getBackground().setColorFilter(Color.parseColor("#CC99FF"), PorterDuff.Mode.MULTIPLY);
		} else {
			// Reset the button appearance
			//button.setTypeface(Typeface.DEFAULT);
			button.getBackground().clearColorFilter();
		}

		final int maxLevel = getMaxLevel(levelSetIndex, this);
		int availableLevels = SokobanLevels.levelMaps.get(levelSetIndex).length;
		button.setText(buttonText + " - " + maxLevel + "/" + availableLevels);
	}

}
