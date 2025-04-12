package au.com.codenhall.sokoban;

import java.util.ArrayList;
import java.util.List;

import au.com.codenhall.sokoban.levels.*;

public class SokobanLevels {
  public static final List<String[][]> levelMaps = new ArrayList<String[][]>();
  static {
    // Thinking Rabbit
    levelMaps.add(new SokobanLevelsOriginalAndExtra().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsBuxxle1().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsBuxxle2().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsPerfect().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsRevenge().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsThinkingRabbitArranged().getSanitisedLevels());

    // Aymeric du Peloux
    levelMaps.add(new SokobanLevelsMiniCosmos().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsMicroCosmos().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsPicoCosmos().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsNaboCosmos().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsCosmonotes().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsCosmopoly().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsMyriocosmos().getSanitisedLevels());

    // David Holland
    levelMaps.add(new SokobanLevelsTheDH1Collection().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsTheDH2Collection().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsTheBagatelleCollection().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsTheBagatelle2Collection().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsTheCantripCollection().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsTheCantrip2Collection().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsTheMaelstromCollection().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsDh5().getSanitisedLevels());

    // David W Skinner
    levelMaps.add(new SokobanLevelsMicroban().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsMicrobanII().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsMicrobanIII().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsMicrobanIV().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsSasquatch().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsMasSasquatch().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsSasquatchIII().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsSasquatchIV().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsSasquatchV().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsSasquatchVI().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsSasquatchVII().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsSasquatchVIII().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsSasquatchIX().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsSasquatchX().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsDavidWSkinnerArranged().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsSasquatchXI().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsSasquatchXII().getSanitisedLevels());

    // Yoshio Murase
    levelMaps.add(new SokobanLevelsYoshioMurasesHandMade().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsYoshioMurasesAuto().getSanitisedLevels());

    // Alberto Garcia
    levelMaps.add(new SokobanLevelsAlbertoGarcia().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsAlbertoGarcia2().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsAlbertoGarcia3().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsAlbertoGarcia4().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsAlberto().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsAlbertoGarciaPlus2().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsAlbertoMultipack().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsBirthday().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsNewYear().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsPuzzle().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsStrategy().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsZigZagPlus().getSanitisedLevels());

    // Eric F Tchong
    levelMaps.add(new SokobanLevelsAruba1().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsAruba2().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsAruba3().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsAruba4().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsAruba5().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsAruba6().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsAruba7().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsAruba8().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsAruba9().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsAruba10().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsAtlas01().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsCosmac().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsCosmac2().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsCosmac3().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsCosmac4().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsCosmac5().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsCosmac6().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsCosmac7().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsCosmac8().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsCosmac9().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsCosmac10().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsSerena1().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsSerena2().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsSerena3().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsSerena4().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsSerena5().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsSerena6().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsSerena7().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsSerena8().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsSerena9().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsAlakina().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsAlejandro().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsAtlas02().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsAtlas03().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsAtlas04().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsAtlas05().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsAtlas06().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsAtlas07().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsAtlas08().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsAtlas09().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsAtlas10().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsCadushi().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsChuchubi01().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsChuchubi02().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsChuchubi03().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsChuchubi04().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsChuchubi05().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsChuchubi06().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsChuchubi07().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsChuchubi08().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsChuchubi09().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsChuchubi10().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsChuchubi11().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsChuchubi12().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsChuchubi13().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsChuchubi14().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsChuchubi15().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsDushi01().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsDushi02().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsDushi03().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsDushi04().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsDushi05().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsDushi06().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsDushi07().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsDushi08().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsDushi09().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsDushi10().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsDushi11().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsDushi12().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsDushi13().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsEricFTchongArranged().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsMango().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsOriginal51_90Remodeled().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsPassionFruit().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsTammyRock().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsBringamosa().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsCappuccino().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsLaGolondrina01().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsUnico().getSanitisedLevels());

    // Evgeniy Grigoriev
    levelMaps.add(new SokobanLevelsGrigr2001().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsGrigr2002().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsGrigrChallenge().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsGrigrComet().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsGrigrSpecial().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsGrigrStar().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsGrigrSun().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsRemodelClub().getSanitisedLevels());

    // Francois Marques
    levelMaps.add(new SokobanLevelsSoloban().getSanitisedLevels());
    levelMaps.add(new SokobanLevels100Boxes().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsNumbers().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsKokoban().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsSokobanOnline().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsSokolate().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsNovoban().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsSokompact().getSanitisedLevels());

    // Howard Abed
    levelMaps.add(new SokobanLevelsHowardLevels1().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsHowardsSecondSet().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsHowardsThirdSet().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsHowardsFourthSet().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsSokoCreation().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsSokobig70().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsSokobig80().getSanitisedLevels());

    // Jaques Duthen
    levelMaps.add(new SokobanLevelsDimitriAndYorick().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsSokogen990602Levels().getSanitisedLevels());

    // Jordi Domenech
    levelMaps.add(new SokobanLevelsHaikemonoCollection().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsHaikemonoCollection2().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsChrysalisVariations01().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsChrysalisVariations02().getSanitisedLevels());

    // Lee Haywood
    levelMaps.add(new SokobanLevelsTheSokHardCollection().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsTheSokEvoCollection().getSanitisedLevels());

    // Marko Dzekic
    levelMaps.add(new SokobanLevelsComplexSimplicity().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsGaladriel().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsMarkoDzekic().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsAmazingOrimazing().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsRemodeling().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsSokoSpace().getSanitisedLevels());

    // Sven Egevad
    levelMaps.add(new SokobanLevelsSharpenCollection().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsSvensCollection().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsYasgood2().getSanitisedLevels());

    // Thomas Reinke
    levelMaps.add(new SokobanLevels81().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsAlbizia().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsAnomaly().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsCalx().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsPatera().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsSokomania().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsTBox().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsTBox2().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsTBox3().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsTBox4().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsTBox5().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsYASGood().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsAnomaly2().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsAnomaly3().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsQuagmire().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsQuagmire2().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsQuagmire3().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsScoria().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsScoria2().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsScoria3().getSanitisedLevels());

    // Misc. authors
    levelMaps.add(new SokobanLevelsFPokornyCollection().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsSylvie().getSanitisedLevels());

    // A1master
    levelMaps.add(new SokobanLevels1000001Candlelights().getSanitisedLevels());
    levelMaps.add(new SokobanLevels1000002Candlelights().getSanitisedLevels());

    // Vipul Patel
    levelMaps.add(new SokobanLevels100000MovesOnly().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsGrigrChallengeRemodeled().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsMastervip().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsMaximum100000Moves().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsNamo().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsSokocrisis().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsSokodeal().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsSokophobia().getSanitisedLevels());

    // xbluejimx
    levelMaps.add(new SokobanLevels12Blocks().getSanitisedLevels());
    levelMaps.add(new SokobanLevels4REC().getSanitisedLevels());

    // Carlos Montiers
    levelMaps.add(new SokobanLevels23x11().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsInitiation().getSanitisedLevels());

    // Dries de Clercq
    levelMaps.add(new SokobanLevels696().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsBlocks().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsGate().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsLined().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsMill().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsOrimazeVariations().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsOrimaze().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsOrimaze2().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsRectangled().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsSquared().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsVarious().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsZone26().getSanitisedLevels());

    // Archanfel
    levelMaps.add(new SokobanLevelsABHT01().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsABHT02().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsABHT03().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsGameOfThrones().getSanitisedLevels());

    // Andrej Cerjak
    levelMaps.add(new SokobanLevelsACSmileys4().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsACDiamonds().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsACEasy().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsACSelected().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsACSmileys().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsACSmileys2().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsACSmileys3().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsPassingBy().getSanitisedLevels());

    // Péter Asztalos
    levelMaps.add(new SokobanLevelsAKKInformatika().getSanitisedLevels());

    // Andre Bernier
    levelMaps.add(new SokobanLevelsInitialTrouble().getSanitisedLevels());

    // Razorflame
    levelMaps.add(new SokobanLevelsAeternus().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsAttrition().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsAttrition05().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsAttrition2().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsAttrition3().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsAttrition4().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsChaoticCatalysts().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsCompactCatalysts().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsCompactCatalysts02().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsFieryCatalysts().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsIonicCatalysts().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsIonicCatalystsReprisal01().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsIonicCatalystsReprisal02().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsLexicalCatalysts().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsLongevity().getSanitisedLevels());

    // Alberto Borella
    levelMaps.add(new SokobanLevelsAlbe().getSanitisedLevels());

    // Alberto Garcia, Spiros Mantzoukis
    levelMaps.add(new SokobanLevelsAlbertoGarciaArranged().getSanitisedLevels());

    // Zhenying, others
    levelMaps.add(new SokobanLevelsAllRemodels().getSanitisedLevels());

    // Michael C Falk
    levelMaps.add(new SokobanLevelsAlphabetSoup().getSanitisedLevels());

    // Milutin Negovanovic
    levelMaps.add(new SokobanLevelsArmadaCollection1().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsAvala().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsHelp().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsMitija().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsMitija1().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsMitija2().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsMitija3().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsMitija4().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsRebus1().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsRedStar().getSanitisedLevels());

    // Tolle
    levelMaps.add(new SokobanLevelsBackToOrigins().getSanitisedLevels());

    // Zivojin Trifunovic
    levelMaps.add(new SokobanLevelsBanjaKoviljaca().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsCer().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsDrina().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsDunav().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsFontana().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsGucevo().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsPacov().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsPark().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsPaulje().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsPiramida().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsPodrinje().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsZika().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsZika1().getSanitisedLevels());

    // Stanislav Kanev
    levelMaps.add(new SokobanLevelsBarona().getSanitisedLevels());

    // Eduardo Santos
    levelMaps.add(new SokobanLevelsBeijingOlympics().getSanitisedLevels());

    // Martí Homs Caussa
    levelMaps.add(new SokobanLevelsSmallerThinnerEasierBetter().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsBoring().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsChoribanLevels().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsHomzLevelsPartII().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsFunnyTemplateLevels().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsHomzLevels().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsMapsAfterAll().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsPicolevels().getSanitisedLevels());

    // Milan Vukosavljevic
    levelMaps.add(new SokobanLevelsBigBen().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsStariFijaker().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsBeear().getSanitisedLevels());

    // Blaz Nikolic
    levelMaps.add(new SokobanLevelsBlazz().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsBlazz2().getSanitisedLevels());

    // zxretrosoft
    levelMaps.add(new SokobanLevelsBrainsportExtreme().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsSokobanExtreme().getSanitisedLevels());

    // Eric F Tchong, Premysil Zika
    levelMaps.add(new SokobanLevelsBravoPremysilZika().getSanitisedLevels());

    // Jorge Gloria
    levelMaps.add(new SokobanLevelsBrunaMaria().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsClassic().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsEasy5Boxes().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsSaquarema().getSanitisedLevels());

    // Bruno Druille
    levelMaps.add(new SokobanLevelsBrunoDruille().getSanitisedLevels());

    // Buddy Casamis
    levelMaps.add(new SokobanLevelsBugs1005Collections().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsBugsCollection138().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsBugsCollection2().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsBugsCollection3().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsBugs509Collection().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsBugs550Collection().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsBugsCollection97().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsBugsSpecialCollection().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsGrigChallengeVariation().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsMoreBugsCollections().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsBugsCollection().getSanitisedLevels());

    // MVP Software
    levelMaps.add(new SokobanLevelsCargoBayDeluxe().getSanitisedLevels());

    // David Buchweitz
    levelMaps.add(new SokobanLevelsChrysalisCollection2().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsChrysalisCollection3().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsChrysalisCollection4().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsChrysalisCollection10().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsChrysalisCollection5().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsChrysalisCollection6().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsChrysalisCollection7().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsChrysalisCollection8().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsChrysalisCollection9().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsChrysalisCollection().getSanitisedLevels());

    // Various Authors
    levelMaps.add(new SokobanLevelsCocktail().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsSokobigRemodels().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsFunLevels().getSanitisedLevels());

    // Vladimir Tockic
    levelMaps.add(new SokobanLevelsVladimirTockicCollection2Demo().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsVladimirTockicCollection().getSanitisedLevels());

    // jhogloria
    levelMaps.add(new SokobanLevelsCookie().getSanitisedLevels());

    // MB
    levelMaps.add(new SokobanLevelsCSoko().getSanitisedLevels());

    // David Dahlem
    levelMaps.add(new SokobanLevelsDD1().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsDD2().getSanitisedLevels());

    // Crazy Monk
    levelMaps.add(new SokobanLevelsDisciple().getSanitisedLevels());

    // Schindler Zoltán
    levelMaps.add(new SokobanLevelsErika().getSanitisedLevels());

    // Erim Sever
    levelMaps.add(new SokobanLevelsErimSeverCollection().getSanitisedLevels());

    // niwa
    levelMaps.add(new SokobanLevelsEscapology().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsPetitesse().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsSquareDance().getSanitisedLevels());

    // Pat Perrodon
    levelMaps.add(new SokobanLevelsFauxPas().getSanitisedLevels());

    // Kevin Cassol
    levelMaps.add(new SokobanLevelsFibonacciChallenge().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsSokoChallenge().getSanitisedLevels());

    // Dries de Clercq, Marko Dzekic
    levelMaps.add(new SokobanLevelsFiveBrothers().getSanitisedLevels());

    // Edwin Abbot
    levelMaps.add(new SokobanLevelsFlatland().getSanitisedLevels());

    // Tim LeFevre
    levelMaps.add(new SokobanLevelsFly().getSanitisedLevels());

    // Gabi Hanisch
    levelMaps.add(new SokobanLevelsGabiAndJenny().getSanitisedLevels());

    // Ghislain Martin
    levelMaps.add(new SokobanLevelsGhislainMartinArranged().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsMonde().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsSokoStation().getSanitisedLevels());

    // Mike McKee, Joe Hitchens
    levelMaps.add(new SokobanLevelsGreenMachine().getSanitisedLevels());

    // Guichard
    levelMaps.add(new SokobanLevelsGuichard().getSanitisedLevels());

    // Gyjgw
    levelMaps.add(new SokobanLevelsGyjgwArranged().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsGyjgwCollection().getSanitisedLevels());

    // Richard Weston
    levelMaps.add(new SokobanLevelsRichardWestonCollection().getSanitisedLevels());

    // Ian Hammond
    levelMaps.add(new SokobanLevelsBrainsport().getSanitisedLevels());

    // DrFogh
    levelMaps.add(new SokobanLevelsItsAllGreek().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsNumbersByDrFogh().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsOriginal01().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsOriginal02().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsOriginal3().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsSokobet().getSanitisedLevels());

    // Ivelin Georgiev Ivanov
    levelMaps.add(new SokobanLevelsTheAdventurer().getSanitisedLevels());

    // Kobus Theron
    levelMaps.add(new SokobanLevelsKobusTheronCollection().getSanitisedLevels());

    // Jean-Pierre Kent
    levelMaps.add(new SokobanLevelsJeanPierreKent().getSanitisedLevels());

    // Kenya Maruyama
    levelMaps.add(new SokobanLevelsKenyamSetA().getSanitisedLevels());

    // Keijo Sopuli
    levelMaps.add(new SokobanLevelsKEASCollection().getSanitisedLevels());

    // Kevin B Reilly
    levelMaps.add(new SokobanLevelsKevin01().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsKevin02().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsKevin03().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsKevin04().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsKevin05().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsKevin06().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsKevin07().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsKevin08().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsKevin09().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsKevin10().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsKevin11().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsKevin12().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsKevin13().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsKevin14().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsKevin15().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsKevin16().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsKevin17().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsKevin18().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsKevin19().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsKevin20().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsKevin21().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsKevinBReillyArranged().getSanitisedLevels());

    // Konstantinos Bozeberg
    levelMaps.add(new SokobanLevelsKos().getSanitisedLevels());

    // Kurt Nittel
    levelMaps.add(new SokobanLevelsKurtNittel1().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsKurtNittel2().getSanitisedLevels());

    // Laizhufu, LZY
    levelMaps.add(new SokobanLevelsLaizhufuAndLZYArranged().getSanitisedLevels());

    // Draku
    levelMaps.add(new SokobanLevelsLearningSokoban().getSanitisedLevels());

    // Li Jin You
    levelMaps.add(new SokobanLevelsLiJinYouCollection().getSanitisedLevels());

    // Many Authors, see each level
    levelMaps.add(new SokobanLevelsLoma().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsMassRemodel().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsVolatileCatalysts().getSanitisedLevels());

    // MF8: Many authors
    levelMaps.add(new SokobanLevelsMF8SokobanCompetition().getSanitisedLevels());

    // MacTommy
    levelMaps.add(new SokobanLevelsMacTommyInventions().getSanitisedLevels());

    // Ward De Langhe
    levelMaps.add(new SokobanLevelsMagicPearls().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsMoreMagicPearls().getSanitisedLevels());

    // Reinhard Hielscher
    levelMaps.add(new SokobanLevelsManyBoxes().getSanitisedLevels());

    // Marcus Palstra
    levelMaps.add(new SokobanLevelsMarcusPalstra().getSanitisedLevels());

    // Mario Bonenfant
    levelMaps.add(new SokobanLevelsMarioBonenfantCollection().getSanitisedLevels());

    // rikitin
    levelMaps.add(new SokobanLevelsMariposa().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsRikyman().getSanitisedLevels());

    // Union Software of Silesia
    levelMaps.add(new SokobanLevelsMasterHead().getSanitisedLevels());

    // York Shen
    levelMaps.add(new SokobanLevelsMicroban01Arranged().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsMicroban02Arranged().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsSasquatch01Arranged().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsSasquatch02Arranged().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsSasquatch03Arranged().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsSasquatch04Arranged().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsSasquatch05Arranged().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsSasquatch06Arranged().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsSasquatch07Arranged().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsYorkShenCollection().getSanitisedLevels());

    // Dries de Clercq, Mark, anian
    levelMaps.add(new SokobanLevelsMillRemodel().getSanitisedLevels());

    // monry
    levelMaps.add(new SokobanLevelsMonryCollection().getSanitisedLevels());

    // monry, Panda
    levelMaps.add(new SokobanLevelsMonryAndPandaArranged().getSanitisedLevels());

    // Hirohiko Nakamiya
    levelMaps.add(new SokobanLevelsMonsterSokoban().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsNakamiya().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsNakamiyaJoy().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsNakamiyaLimit().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsNakamiyaPractice().getSanitisedLevels());

    // Shaggath
    levelMaps.add(new SokobanLevelsMulholland2().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsMulhollandD().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsV2009().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsV2010().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsV2014().getSanitisedLevels());

    // DrFogh, Archanfel, Joseph L Traub
    levelMaps.add(new SokobanLevelsOriginalExtraSharpen().getSanitisedLevels());

    // Findus
    levelMaps.add(new SokobanLevelsPayback01().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsPayback02().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsPayback03().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsPayback04().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsPayback05().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsPayback06().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsPayback07().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsPayback08().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsPayback09().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsPayback10().getSanitisedLevels());

    // Perka
    levelMaps.add(new SokobanLevelsJoke().getSanitisedLevels());

    // Morganine
    levelMaps.add(new SokobanLevelsRandoms().getSanitisedLevels());

    // Roger Delaporte
    levelMaps.add(new SokobanLevelsRdlom().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsRogerDelaporte().getSanitisedLevels());

    // Marcus Hof
    levelMaps.add(new SokobanLevelsRevenge13().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsRevenge14().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsRevenge15().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsRevenge16().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsRevenge17().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsRevenge18().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsRevenge19().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsRevenge20().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsRevenge21().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsRevenge22().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsRevenge23().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsRevenge24().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsRevenge25().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsRevenge26().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsRevenge27().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsRevenge28().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsRevenge29().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsRevenge30().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsRevenge31().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsRevenge32().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsRevenge33().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsRevenge34().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsRevenge35().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsRevenge36().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsRevenge37().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsRevenge38().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsRevenge39().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsRevengeCollection01().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsRevengeCollection02().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsRevengeCollection03().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsRevengeCollection04().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsRevengeCollection05().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsRevengeCollection06().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsRevengeCollection07().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsRevengeCollection08().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsRevengeCollection09().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsRevengeCollection10().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsRevengeCollection11().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsRevengeCollection12().getSanitisedLevels());

    // TIAOA
    levelMaps.add(new SokobanLevelsSBMendonca01().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsSBMendonca02().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsSBMendonca03().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsSBMendonca04().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsSBMendonca05().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsSBMendonca06().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsSBMendoncaLivres().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsSBMendoncaModifications().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsSBMendoncaRemodeled().getSanitisedLevels());

    // Muhammad Umar
    levelMaps.add(new SokobanLevelsTheFirstOne().getSanitisedLevels());

    // Pøemysl Zíka
    levelMaps.add(new SokobanLevelsSecundusGradusAdOlympo().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsTertiusGradusAdOlympo1().getSanitisedLevels());

    // Serg Belyaev
    levelMaps.add(new SokobanLevelsSergBelyaev1().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsSergBelyaev2().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsSergBelyaev3().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsSergBelyaev4().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsSergBelyaev5().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsSergBelyaev6().getSanitisedLevels());

    // Phil Shapiro
    levelMaps.add(new SokobanLevelsSimpleCollection().getSanitisedLevels());

    // yotyot
    levelMaps.add(new SokobanLevelsSimplistic().getSanitisedLevels());

    // Lars Nilsson
    levelMaps.add(new SokobanLevelsSimply().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsSokoLasse().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsSokolasse2().getSanitisedLevels());

    // Kevin B Reilly, Gerald Holler
    levelMaps.add(new SokobanLevelsSokoMind().getSanitisedLevels());

    // Wayne Campbell
    levelMaps.add(new SokobanLevelsSokobanOriginalPuzzlesTributeL().getSanitisedLevels());

    // Einar Saukas
    levelMaps.add(new SokobanLevelsSokoBonus().getSanitisedLevels());

    // Laura Wheeler
    levelMaps.add(new SokobanLevelsSokobanJunior1().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsSokobanJunior2().getSanitisedLevels());

    // PK2497
    levelMaps.add(new SokobanLevelsSokoking01().getSanitisedLevels());

    // Matthias 'muh' Pauligk
    levelMaps.add(new SokobanLevelsTheSolversUnsolvable().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsSundayWarmup().getSanitisedLevels());

    // Aleksey Krupenko
    levelMaps.add(new SokobanLevelsSonic().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsSonic2().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsSonic3().getSanitisedLevels());

    // Kseniya Mierzejewska
    levelMaps.add(new SokobanLevelsSpirals().getSanitisedLevels());

    // Spiros Mantzoukis
    levelMaps.add(new SokobanLevelsSpiros01().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsSpiros02().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsSpiros03().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsSpiros04().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsSpiros05().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsSpiros06().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsSpiros07().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsSpiros8().getSanitisedLevels());

    // J Franklin Mentzer
    levelMaps.add(new SokobanLevelsStillMoreCollection().getSanitisedLevels());

    // Sylvain Gravejat, Guillaume Gravejat
    levelMaps.add(new SokobanLevelsSylvainGravejat().getSanitisedLevels());

    // Seppolino
    levelMaps.add(new SokobanLevelsSymmetrixx().getSanitisedLevels());

    // Ken'ichiro Takahashi (takaken)
    levelMaps.add(new SokobanLevelsTakakenCollection().getSanitisedLevels());

    // Mark
    levelMaps.add(new SokobanLevelsTheHouse().getSanitisedLevels());

    // XiBei Tian Lang
    levelMaps.add(new SokobanLevelsTianLang().getSanitisedLevels());

    // John Polhemus
    levelMaps.add(new SokobanLevelsTitleScreens().getSanitisedLevels());

    // Wilfrid Geiser
    levelMaps.add(new SokobanLevelsTrapdooooooooors().getSanitisedLevels());

    // Martin P Holland
    levelMaps.add(new SokobanLevelsTwisty().getSanitisedLevels());

    // W M Dekker
    levelMaps.add(new SokobanLevelsSoundextensionsAndCircles().getSanitisedLevels());

    // Rick Sladkey
    levelMaps.add(new SokobanLevelsTheWarehouseIVerticalMobility().getSanitisedLevels());

    // Iroh
    levelMaps.add(new SokobanLevelsWarehouse().getSanitisedLevels());

    // Brian Damgaard
    levelMaps.add(new SokobanLevelsYASGen().getSanitisedLevels());

    // Yut
    levelMaps.add(new SokobanLevelsYut().getSanitisedLevels());

    // Zbigniew Kornas
    levelMaps.add(new SokobanLevelsZbigniewKornas().getSanitisedLevels());

    // Zeljko Negovanovic
    levelMaps.add(new SokobanLevelsZelja().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsZelja1().getSanitisedLevels());

    // Brian Kent
    levelMaps.add(new SokobanLevelsBrianKentsSokoban2K().getSanitisedLevels());

    // Doreen Kaufmann, Rainer Kaufmann
    levelMaps.add(new SokobanLevelsDemonsAndDiamonds().getSanitisedLevels());
    levelMaps.add(new SokobanLevelsCubesAndTubes().getSanitisedLevels());

    // Frantisek Pokorny
    levelMaps.add(new SokobanLevelsFrantisekPokornyCollection().getSanitisedLevels());

    // John C Davis
    levelMaps.add(new SokobanLevelsJCDLevels().getSanitisedLevels());

    // Joris Wit
    levelMaps.add(new SokobanLevelsJw2005().getSanitisedLevels());

    // Karl-Heinz Böhm
    levelMaps.add(new SokobanLevelsKalle1().getSanitisedLevels());

    // Kirill
    levelMaps.add(new SokobanLevelsKisser().getSanitisedLevels());

    // 00XIAN
    levelMaps.add(new SokobanLevelsOoxian().getSanitisedLevels());
  }
}
