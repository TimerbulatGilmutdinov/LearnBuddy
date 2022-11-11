package ru.kpfu.itis.semestrproject.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserSubject {
    private Long userId;
    private boolean maths;
    private boolean physics;
    private boolean englishLanguage;
    private boolean programming;
    private boolean history;
    private boolean economics;
    private boolean law;
}
