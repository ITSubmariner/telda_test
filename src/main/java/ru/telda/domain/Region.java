package ru.telda.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Region {
    private long id;
    @NonNull private String name;
    @NonNull private String title;
}
