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
package com.hukacode.common.usecase;

import javax.validation.ConstraintViolationException;
import javax.validation.Validation;

public abstract class AbstractUseCaseHandler<I, O> implements UseCase<I, O> {
  @Override
  public O execute(I input) {
    if (input == null) {
      throw new ValidationException("Input must be not null");
    }

    var factory = Validation.buildDefaultValidatorFactory();
    var validator = factory.getValidator();
    var violations = validator.validate(input);

    if (!violations.isEmpty()) {
      throw new ConstraintViolationException(violations);
    }

    checkPrerequisite(input);
    return business(input);
  }

  public abstract void checkPrerequisite(I input);

  public abstract O business(I input);
}
