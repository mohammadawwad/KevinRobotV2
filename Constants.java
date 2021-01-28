package frc.robot;

public final class Constants 
{
    /*-------------------------MOTORS--------------------*/
    //DRIVE TRAIN MOTORS
    public static final int FRONT_RIGHT_MOTOR_ID = 4;                           //Spark
    public static final int BACK_RIGHT_MOTOR_ID = 3;                           //Spark
    public static final int FRONT_LEFT_MOTOR_ID = 2;                          //Spark
    public static final int BACK_LEFT_MOTOR_ID = 1;                          //Spark
    //HOPPER MOTORS                                                         //
    public static final int HOPPER_1_MOTOR_ID = 0;                         //Victor
    public static final int HOPPER_2_MOTOR_ID = 1;                        //Victor
    public static final int FEEDER_MOTOR_ID = 2;                         //Talon
    //SHOOTER MOTORS                                                    //
    public static final int SHOOTER_LEFT_MOTOR_ID = 5;                 //Spark
    public static final int SHOOTER_RIGHT_MOTOR_ID = 6;               //Spark
     //INTAKE MOTORS                                                 //
    public static final int INTAKE_1_MOTOR_ID = 4; //2                 //Talon
    public static final int INTAKE_2_MOTOR_ID = 1;                 //Talon
     //WHEEL MOTOR                                                //
    public static final int WHEEL_SPINNER_MOTOR_ID = 3;//3          //Talon
    //servo
    public static final int HUD_ADJUSTER = 2;

/*-----------------CONTROLLERS-----------------*/    
    //MAPPING JOYSTICK/XBOX BUTTON
    public static final int JOYSTICK_BUTTON_1 = 1;
    public static final int JOYSTICK_BUTTON_2 = 2;
    public static final int JOYSTICK_BUTTON_3 = 3;
    public static final int JOYSTICK_BUTTON_4 = 4;
    public static final int JOYSTICK_BUTTON_5 = 5;
    public static final int JOYSTICK_BUTTON_6 = 6;
    public static final int JOYSTICK_BUTTON_7 = 7;
    public static final int JOYSTICK_BUTTON_8 = 8;
    public static final int JOYSTICK_BUTTON_9 = 9;
    public static final int JOYSTICK_BUTTON_10 = 10;
    public static final int JOYSTICK_BUTTON_11 = 11;
    public static final int JOYSTICK_BUTTON_12 = 12;

    public static final int XBOX_BUTTON_A = 1;
    public static final int XBOX_BUTTON_B = 2;
    public static final int XBOX_BUTTON_X = 3;
    public static final int XBOX_BUTTON_Y = 4;
    public static final int XBOX_BUMPER_LEFT = 5;
    public static final int XBOX_BUMPER_RIGHT = 6;
    public static final int XBOX_BUTTON_BACK = 7;
    public static final int XBOX_BUTTON_START = 8;
    public static final int XBOX_BUTTON_LEFT_JOYSTICK_IN = 9;
    public static final int XBOX_BUTTON_RIGHT_JOYSTICK_IN = 10;
    public static final int XBOX_LEFT_AXIS = 1;
    //JOYSTICK PORT
    public static final int JOYSTICK_CONTROLLER = 0;
    //XBOX PORT
    public static final int XBOX_CONTROLLER = 1;
    // axis
    public static final int THROTLE = 3;
    public static final int STICK_Y = 1;
    public static final int STICK_Z = 2;
/*------------------------PNEUMATICS----------------*/

    //PNEUMATICS
    public static final int CLIMBER_SOLENOID = 6;
    public static final int GEARSHIFT_SOLENOID = 7;
    public static final int INTAKE_SOLENOID = 4;
    public static final int COLOURARM_SOLENOID = 5;

/*-------------------ENCODERS-------------------*/    
    //WHEEL ENCODER
    
/*-------------------Servo----------------------*/
//Control Pannel
public static final int HUD_ADJUSTER_SERVER = 2;    
/*--------------------Other---------------------*/
public static final int PDP_DEVICE_ID = 0;
public static final int PCM_DEVICE_ID = 0;
/*------------------Colours--------------------*/
public static final double COLOR_SENSOR_CONFIDENCE = 0.95;



public static double[] BlueTarget()
{
    double[] BlueTarget = new double[3]; 
    BlueTarget[0] = 0.143;
    BlueTarget[1] = 0.427; 
    BlueTarget[2] = 0.429;
    return BlueTarget;

}
public static double[] GreenTarget()
{
    double[] GreenTarget = new double[3]; 
    GreenTarget[0] = 0.197;
    GreenTarget[1] = 0.561; 
    GreenTarget[2] = 0.240;
    return GreenTarget;

}
public static double[] RedTarget()
{
    double[] RedTarget = new double[3]; 
    RedTarget[0] = 0.561;
    RedTarget[1] = 0.232; 
    RedTarget[2] = 0.114;
    return RedTarget;

}
public static double[] YellowTarget()
{
    double[] YellowTarget = new double[3]; 
    YellowTarget[0] = 0.361;
    YellowTarget[1] = 0.524; 
    YellowTarget[2] = 0.113;
    return YellowTarget;

}

}
