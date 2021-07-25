/*
 * Copyright 2021 https://github.com/hukacode/huka-common
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.hukacode.common.validation.annotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import com.hukacode.common.validation.annotation.DepartmentName.List;
import java.lang.annotation.Documented;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@NotBlank
@Size(min = 1, max = 20)
@Documented
@Constraint(validatedBy = {})
@Target({FIELD})
@Retention(RUNTIME)
@Repeatable(List.class)
public @interface DepartmentName {

  String message() default "{com.hukacode.sp.common.validation.constraints.name.message}";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};

  @Target({FIELD})
  @Retention(RUNTIME)
  @Documented
  @interface List {

    DepartmentName[] value();
  }
}
