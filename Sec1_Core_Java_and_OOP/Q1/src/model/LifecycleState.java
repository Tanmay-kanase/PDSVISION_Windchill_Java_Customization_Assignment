package model;
// reason behind using enum is consistency in fields as we can insert in-work , working , preparing etc meaning is 
// same but by using enums we can achieve consistency and readability.
public enum LifecycleState {
    IN_WORK,
    UNDER_REVIEW,
    RELEASED,
    APPROVED,
    OBSOLETE
}